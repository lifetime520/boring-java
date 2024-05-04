function buy {
curl 'https://api.btse.com/futures/api/v2.1/order' \
  -H @./authorization.clrc \
  --data-raw '{"side":"BUY","symbol":"BTC-PERP","type":"MARKET","size":"'$1'","reduceOnly":false,"txType":"LIMIT","positionMode":"ONE_WAY"}' \
  | json_pp >> ~/trading/logs/`date +"%Y%m%d"`.btse.log &
}
function sell {
curl 'https://api.btse.com/futures/api/v2.1/order' \
  -H @./authorization.clrc \
  --data-raw '{"side":"SELL","symbol":"BTC-PERP","type":"MARKET","size":"'$1'","reduceOnly":false,"txType":"LIMIT","positionMode":"ONE_WAY"}' \
  | json_pp >> ~/trading/logs/`date +"%Y%m%d"`.btse.log &
}

case $1 in
  BUY|buy|B|b):
    for i in `seq 1 $3`;
    do
      echo 'Round:' $i
      buy $2
    done
    ;;
  SELL|sell|S|s):
    for i in `seq 1 $3`;
    do
      echo 'Round:' $i
      sell $2 
    done
    ;;
  rndBUY|rndBuy|rB|rb):
    for i in `seq 1 $3`;
    do
      echo 'Round:' $i
      buy $(($RANDOM % $2 + 1))
    done
    ;;
  rndSELL|rndSell|rS|rs):
    for i in `seq 1 $3`;
    do
      echo 'Round:' $i
      sell $(($RANDOM % $2 + 1))
    done
    ;;
  *)
    echo 'What are you tolking about'
esac
