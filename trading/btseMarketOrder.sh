## README
# brew install coreutils jsonpp
## Options
# $(uuidgen | tr 'A-Z' 'a-z')
function buy {
curl 'https://api.btse.com/futures/api/v2.1/order' \
  -H @./authorization.clrc \
  --data-raw '{"side":"BUY","symbol":"BTC-PERP","type":"MARKET","size":"'$1'","reduceOnly":false,"txType":"LIMIT","positionMode":"ONE_WAY","clOrderID":"_W_'$2'"}' \
  | json_pp | grep -v -E 'ion(D|M)|dev|order(D|T)|time_i|tr|sym|Si' | sed -E 's/(size" : [0-9]+),/\1/g' >> ./logs/`date +"%Y%m%d"`.btse.log &
}
function sell {
curl 'https://api.btse.com/futures/api/v2.1/order' \
  -H @./authorization.clrc \
  --data-raw '{"side":"SELL","symbol":"BTC-PERP","type":"MARKET","size":"'$1'","reduceOnly":false,"txType":"LIMIT","positionMode":"ONE_WAY","clOrderID":"_W_'$2'"}' \
  | json_pp | grep -v -E 'ion(D|M)|dev|order(D|T)|time_i|tr|sym|Si' | sed -E 's/(size" : [0-9]+),/\1/g' >> ./logs/`date +"%Y%m%d"`.btse.log &
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
  rb):
    for i in `seq 1 $3`;
    do
      echo 'Round:' $i
      buy $(($RANDOM % $2 + 1)) $(uuidgen | tr 'A-Z' 'a-z') &
    done
    ;;
  rs):
    for i in `seq 1 $3`;
    do
      echo 'Round:' $i
      sell $(($RANDOM % $2 + 1)) $(uuidgen | tr 'A-Z' 'a-z') &
    done
    ;;
  *)
    echo 'What are you tolking about'
esac
