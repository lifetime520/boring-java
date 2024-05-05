## README
# brew install coreutils jsonpp
## Options
# $(uuidgen | tr 'A-Z' 'a-z')
function placeMarketOrder {
  curl 'https://api.btse.com/futures/api/v2.1/order' \
    -H @./authorization.clrc \
    --data-raw '{"side":"'$1'","symbol":"BTC-PERP","type":"MARKET","size":"'$2'","reduceOnly":false,"txType":"LIMIT","positionMode":"ONE_WAY","clOrderID":"_W_'$(uuidgen | tr 'A-Z' 'a-z')'"}' \
    | json_pp | grep -v -E 'ion(D|M)|dev|order(D|T)|time_i|tr|sym|Si|lth|On' | sed -E 's/(timestamp" : [0-9]+),/\1/g' >> ./logs/`date +"%Y%m%d"`.btse.log &
}
function closePosition {
  curl 'https://api.btse.com/futures/api/v2.2/order/close_position' \
    -H 'accept: application/json, text/plain, */*' \
    -H 'authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE3MTQ4NjY4OTcsImV4cCI6MTcxNDk1MzM1NywiaXNzIjoiYnRzZS5wcmQiLCJhdWQiOiJjbGllbnQuc2VydmljZSIsInVzZXJuYW1lIjoiY2FzdGllbGxvdHNhaSIsImNsaWVudElkIjoiYnRzZSIsInJhbmRvbSI6IjAuNzg0NTI4MDgyNDYzODYyMSIsImRldmljZVR5cGUiOiJ3ZWIiLCJkZXZpY2VJZCI6bnVsbCwic2NvcGVzIjpbInRydXN0ZWQiXX0.TYubZ6HEl7wwgIGYmePXE4modMZB61tAAe5b0sYk2fw' \
    -H 'content-type: application/json' \
    -H 'user-agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36' \
    --data-raw '{"symbol":"BTC-PERP","type":"MARKET","positionId":"BTC-PERP-USDT","clOrderID":"_W_'$(uuidgen | tr 'A-Z' 'a-z')'"}' 
    # \
    # | json_pp
     # | grep -v -E 'ion(D|M)|dev|order(D|T)|time_i|tr|sym|Si|lth|On' | sed -E 's/(timestamp" : [0-9]+),/\1/g' >> ./logs/`date +"%Y%m%d"`.btse.log &
}

case $1 in
  BUY|buy|B|b):
    for i in `seq 1 $3`;
    do
      echo 'Round:' $i
      placeMarketOrder 'BUY' $2 &
    done
    ;;
  SELL|sell|S|s):
    for i in `seq 1 $3`;
    do
      echo 'Round:' $i
      placeMarketOrder 'SELL' $2 &
    done
    ;;
  rb):
    for i in `seq 1 $3`;
    do
      echo 'Round:' $i
      placeMarketOrder 'BUY' $(($RANDOM % $2 + 1)) &
    done
    ;;
  rs):
    for i in `seq 1 $3`;
    do
      echo 'Round:' $i
      placeMarketOrder 'SELL' $(($RANDOM % $2 + 1)) &
    done
    ;;
  cp):
    closePosition
    ;;
  *)
    echo 'What are you tolking about'
esac
