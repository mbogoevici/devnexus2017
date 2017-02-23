SENSORS=$1
MIN=$2
MAX=$3
RANGE=$(( $MAX - $MIN ))
while true; do
for ((i=0; i<=($SENSORS-1); i++)); do
  VALUE=$(echo "scale=2;$RANDOM/32767 * $RANGE + $MIN + $i" | bc)
  DATA="{\"sensor_id\":$i,\"temp_val\":$VALUE}"
  echo $DATA
  curl -i -H "Accept: application/json" -H "Content-Type:application/json"  \
       -X POST -d $DATA https://mlp-scdf-1c1eloy-sensorstream-rxhttp.cfapps.io/
done
sleep 0.1
done
