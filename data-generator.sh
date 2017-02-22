SENSORS=$1
MIN=$2
MAX=$3
RANGE=$(( $MAX - $MIN ))
while true; do
for ((i=0; i<=($SENSORS-1); i++)); do
  VALUE=$(echo "scale=2;$RANDOM/32767 * $RANGE + $MIN + $i" | bc)
  DATA="{\"id\":$i,\"temperature\":$VALUE}"
  echo $DATA
  curl -i -H "Accept: application/json" -H "Content-Type:application/json"  \
       -X POST -d $DATA http://localhost:8080
done
sleep 0.1
done