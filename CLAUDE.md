# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## 專案總覽

這個 repo 是**作者的個人實驗場**，放著三個彼此無關的小專案。**沒有頂層 Gradle 配置**（沒有 root `build.gradle` / `settings.gradle`），每個子專案各自獨立構建。任何 gradle 指令都**必須先 `cd` 進子專案目錄**，在 root 跑 `./gradlew` 會失敗。

| 子專案 | 類型 | 語言/版本 | 狀態 |
|---|---|---|---|
| `sudoku/` | 數獨求解器（algo 練習） | Java 17, Spring Boot 3.1.1 | 可運作 |
| `configmgmt/` | SSH 配置管理工具 | Java 11, Spring Boot 3.1.2 | **骨架，主邏輯未實作** |
| `trading/` | BTSE 期貨下單腳本 | Bash + curl | 可運作但有歷史敏感資料（見下方） |

---

## sudoku — 數獨求解器

- **套件根**: `org.castiello.game.sudoku`
- **入口**: `Application.java` 在 `main()` 中硬編碼了 5 個難度的盤面，啟動時依序呼叫 `SolveCompoundMultiFlow` 與 `SolveCompoundFlow.solving(input)`，**不是 Web 服務**。
- **Spring Boot 用途**: 只是為了 DI / 啟動方便；`@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)` 排除了 JPA 自動配置。Logging 用 **log4j2**（`spring-boot-starter-logging` 已被 exclude）。
- **核心架構（策略 + 編排兩層）**:
  - `algo/IAlgorithm<R>` 是 functional interface，接收 `SudokuEntry[][]`；`algo/ISolveAlgorithm<R>` 繼承之。
  - `algo/impl/` 下每個演算法各自獨立可組合：`ConstraintAlgorithm`（約束傳播）、`DFSAlgorithm`、`BFSAlgorithm`、`CompoundAlgorithm`（約束 + DFS 回溯）、`CompoundMultiSolutionAlgorithm`（多解搜尋）、`GenerateKeyAlgorithm`、`SudokuVerifyAlgorithm`。
  - `flow/IFLow<I,R>.solving(I)` 是編排入口；`flow/impl/SolveCompoundFlow` 與 `SolveCompoundMultiFlow` 把演算法串起來。
  - `item/impl/SudokuItem.java` 是核心狀態容器；`dto/SudokuEntry.java` 是單元格（座標 + 答案 + 候選集）。
- **指令**:
  ```bash
  cd sudoku
  ./gradlew build          # 編譯 + 測試
  ./gradlew test           # 只跑測試（JUnit 5）
  ./gradlew test --tests "ClassName.method"   # 跑單一測試
  ./gradlew bootRun        # 跑求解（會把硬編碼盤面解過一遍，log 寫到 logs/）
  ```

---

## configmgmt — SSH 配置管理工具（骨架）

- **套件根**: `org.castiello.ssh.configmgmt`
- **入口**: `Application.java` 實作 `CommandLineRunner.run()`，但**方法體是空 TODO**，目前不做任何事。整個專案只有 `Application.java` + 自動產生的 `ConfigmgmtApplicationTests.java`。
- **依賴**: `spring-boot-starter` + `commons-csv 1.10.0`，暗示原計畫是讀 CSV 產生 SSH 配置。
- **⚠️ 已知地雷**:
  - `build.gradle` 宣告 `sourceCompatibility = '11'`，但 Spring Boot 3.x **需要 Java 17+**。編譯可能會過，但執行階段在現代 JDK 上能跑、在 JDK 11 上會炸。動到這個專案前先評估要升 Java 版本還是降 Spring Boot 版本。
- **指令**:
  ```bash
  cd configmgmt
  ./gradlew build
  ./gradlew test
  ```

---

## trading — BTSE 期貨下單 Bash 腳本

- **非 Java 專案**，不參與任何 Gradle build。
- **檔案**:
  - `btseMarketOrder.sh` — BTSE 期貨市價單腳本，支援子指令：`BUY/SELL` 固定 size 連發、`rb/rs` 隨機 size 連發、`cp` 平倉。會用 `curl` 打 `api.btse.com/futures/api/v2.1/order` 與 `v2.2/order/close_position`，回應寫進 `logs/YYYYMMDD.btse.log`。
  - `authorization.clrc` — 給 `curl -H @file` 用的 authorization header 配置檔案（**不要 commit 任何包含 token 的版本**）。
- **⚠️ 歷史敏感資料警告**: `btseMarketOrder.sh:14`（`closePosition` 函式內）目前**硬編碼**了一個 BTSE Bearer JWT。觀察其 `exp` 欄位（1714953357 ≈ 2024-05-06）已過期，但仍是歷史洩漏。**未來新增 / 修改此腳本時請改為讀取 `authorization.clrc` 或環境變數，不要重複此 anti-pattern**。
- **執行範例**（需先準備好 `authorization.clrc`）:
  ```bash
  cd trading
  ./btseMarketOrder.sh BUY  10 3   # 連發 3 筆市價買單，size=10
  ./btseMarketOrder.sh rs   5  10  # 連發 10 筆隨機 size (1..5) 市價賣單
  ./btseMarketOrder.sh cp          # 平倉（注意硬編碼 token 問題）
  ```

---

## 開發環境注意事項

- Eclipse Buildship 整合存在（`.project` / `.classpath` / `.settings` 已 commit），但 IDE 中重新匯入時請選 Gradle import，並針對每個子專案各自匯入。
- 各子專案的 Gradle Wrapper 版本獨立（目前 sudoku / configmgmt 皆為 8.1.1）。
- `.remember/` 目錄是個人記憶系統，**不是程式邏輯**，不要當成模組讀。

## 跨子專案修改的原則

- 三個專案彼此無相依，不要為了「統一風格」而強行同步版本或結構，這違背作者「實驗場」的定位。
- 若新增第四個子專案，沿用相同模式：在 root 開一個新目錄，內含獨立的 `build.gradle` + `settings.gradle` + `gradlew`，**不要嘗試引入頂層 `settings.gradle include` 改成 multi-project**，除非用戶明確要求。
