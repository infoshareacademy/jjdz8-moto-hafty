FROM jboss/wildfly

MAINTAINER "BookShare"

RUN wildfly/bin/add-user.sh admin admin --silent

ADD web-app/target/bookshare-web.war wildfly/standalone/deployments/

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]