# Master starten
/spark/sbin/start-master.sh
#Slave starten
sleep 5
/spark/sbin/start-slave.sh spark://spark:7777

#Speicherzuweisung
 cp /spark/conf/spark-defaults.conf.template /spark/conf/spark-defaults.conf
 echo "Speicherzuweisung" >> /spark/conf/spark-defaults.conf
sleep 10

#Starten der JAR
#./spark/bin/spark-submit \
  --class Main\
  --master spark://spark:7777 \
  /blabla/UnsereJAr.jar

# run endless loop to keep alive
/usr/bin/tail -f /dev/null
