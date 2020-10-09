#!/usr/bin/env bash
#wait for the MySQL Server to come up
#sleep 90s

chmod 644 /etc/mysql/conf.d/my.cnf

#run the setup script to create the DB and the schema in the DB
mysql -u docker -pdocker test_database < "/docker-entrypoint-initdb.d/001-create-tables.sql"
mysql -u docker --local-infile=1 -pdocker test_database < "/docker-entrypoint-initdb.d/002-insert-data.sql"
