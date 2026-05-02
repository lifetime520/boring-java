# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## 專案總覽

這是一個 Gradle 多模組 Java 專案，包含三個獨立的子專案，各自有自己的 `build.gradle` 和 `settings.gradle`，**沒有** 頂層的 Gradle 配置。每個子專案獨立構建和運行。

## 子專案結構

### sudoku — 數獨求解器
- **路徑**: `sudoku/`
- **套件**: `org.castiello.game.sudoku`
- **Java**: 17, Spring Boot 3.1.1, Log4j2, H2, JPA
- **入口**: `Application.java` — 直接在 `main()` 中以硬編碼字串運行求解，非 Web 服務
- **核心架構**:
  - `algo/` — 策略模式實現多種算法：`IAlgorithm<R>` 是 functional interface，接收 `SudokuEntry[][]`；`ISolveAlgorithm<R>` 繼承它
  - `algo/impl/` — `ConstraintAlgorithm`（約束傳播）、`DFSAlgorithm`、`BFSAlgorithm`、`CompoundAlgorithm`（組合約束+DFS回溯）、`CompoundMultiSolutionAlgorithm`、`GenerateKeyAlgorithm`、`SudokuVerifyAlgorithm`
  - `flow/` — `IFLow<I,R>` 定義 `solving(I)` 方法，`SolveCompoundFlow` 和 `SolveCompoundMultiFlow` 是入口編排層
  - `item/impl/SudokuItem.java` — 核心資料結構，封裝數獨盤面狀態和候選值
  - `dto/SudokuEntry.java` — 單元格 DTO，包含座標、答案和候選選項
- **構建與測試**:
  - `cd sudoku && ./gradlew build`
  - `cd sudoku && ./gradlew test`
  - `cd sudoku && ./gradlew bootRun`

### configmgmt — SSH 配置管理工具
- **路徑**: `configmgmt/`
- **套件**: `org.castiello.ssh.configmgmt`
- **Java**: 11, Spring Boot 3.1.2, Apache Commons CSV
- **入口**: `Application.java` — 實現 `CommandLineRunner`，主邏輯為 TODO 狀態
- **構建與測試**:
  - `cd configmgmt && ./gradlew build`
  - `cd configmgmt && ./gradlew test`

### trading — Shell 交易腳本
- **路徑**: `trading/`
- 非 Java 專案，純 Bash 腳本
- `btseMarketOrder.sh` — BTSE 期貨市價單腳本，支援 BUY/SELL/隨機批量下單/平倉，使用 `curl` 呼叫 BTSE REST API
- `authorization.clrc` — curl 請求用的 authorization header 配置檔案

## 開發環境

- 專案使用 Eclipse Buildship (Gradle 整合)，`.project` / `.classpath` / `.settings` 已提交
- 每個子專案的 Gradle Wrapper 獨立，版本各異（sudoku/configmgmt: 8.1.1）
