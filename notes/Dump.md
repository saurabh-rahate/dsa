To compare the performance of normal mode and downstream integrated capture mode for copying data from Oracle DB to MongoDB using Oracle GoldenGate, you can set up a local environment using Docker images. Here is a step-by-step guide to help you achieve this:

### Prerequisites

1. **Docker**: Make sure Docker is installed on your machine.
2. **Docker Compose**: This helps in managing multiple Docker containers easily.
3. **Oracle Database Docker Image**: Use an official Oracle Database Docker image.
4. **MongoDB Docker Image**: Use an official MongoDB Docker image.
5. **Oracle GoldenGate for Big Data Docker Image**: You'll need the GoldenGate for Big Data image that supports both Oracle and MongoDB.

### Step-by-Step Guide

#### Step 1: Set Up Oracle Database

Create a `docker-compose.yml` file to set up Oracle Database.

```yaml
version: '3'
services:
  oracle-db:
    image: oracleinanutshell/oracle-xe-11g
    ports:
      - "1521:1521"
    environment:
      - ORACLE_ALLOW_REMOTE=true
    volumes:
      - ./oracle-data:/u01/app/oracle
```

Run the Docker container:

```sh
docker-compose up -d
```

#### Step 2: Set Up MongoDB

Add MongoDB service to the `docker-compose.yml` file.

```yaml
version: '3'
services:
  oracle-db:
    image: oracleinanutshell/oracle-xe-11g
    ports:
      - "1521:1521"
    environment:
      - ORACLE_ALLOW_REMOTE=true
    volumes:
      - ./oracle-data:/u01/app/oracle

  mongodb:
    image: mongo
    ports:
      - "27017:27017"
    volumes:
      - ./mongo-data:/data/db
```

Run the Docker container:

```sh
docker-compose up -d
```

#### Step 3: Set Up Oracle GoldenGate for Big Data

Since there is no official Oracle GoldenGate for Big Data Docker image, you might need to create a custom Docker image or use a VM-based approach. Here’s an example Dockerfile:

```Dockerfile
FROM oraclelinux:7-slim

# Install required packages
RUN yum install -y oracle-release-el7 && \
    yum install -y oracle-goldengate-for-big-data

# Add GoldenGate configuration files
COPY ggsci /usr/local/ogg/
WORKDIR /usr/local/ogg/

# Expose necessary ports
EXPOSE 7809 7810
```

Build and run the Docker container:

```sh
docker build -t ogg-bigdata .
docker run -d --name ogg-bigdata -p 7809:7809 -p 7810:7810 ogg-bigdata
```

#### Step 4: Configure Oracle GoldenGate

1. **Set Up the Extract Process**: Configure the Extract process to capture changes from the Oracle database.
2. **Set Up the Replicat Process**: Configure the Replicat process to apply changes to MongoDB.

#### Example Configuration

1. **Extract Configuration (normal mode)**:

```plaintext
EXTRACT ext1
USERID ggs_admin@orcl, PASSWORD password
EXTTRAIL ./dirdat/et
TABLE schema_name.table_name;
```

2. **Replicat Configuration**:

```plaintext
REPLICAT rep1
TARGETDB mongodb, USERID user, PASSWORD password
MAP schema_name.table_name, TARGET mongodb_db.table_name;
```

3. **Extract Configuration (downstream integrated capture mode)**:

```plaintext
EXTRACT ext2
USERID ggs_admin@orcl, PASSWORD password
EXTTRAIL ./dirdat/et
TRANLOGOPTIONS INTEGRATEDPARAMS (MAX_SGA_SIZE 2048, PARALLELISM 4)
TABLE schema_name.table_name;
```

### Step 5: Run and Test

1. **Start GoldenGate Processes**: Start the Extract and Replicat processes using GGSCI commands.
2. **Monitor Performance**: Use monitoring tools to compare the performance of normal mode and downstream integrated capture mode.

### Additional Resources

- [Oracle GoldenGate Documentation](https://docs.oracle.com/en/middleware/goldengate/index.html)
- [Oracle GoldenGate for Big Data Documentation](https://docs.oracle.com/en/middleware/goldengate/big-data/index.html)
- [Docker Oracle Database Image](https://hub.docker.com/r/oracleinanutshell/oracle-xe-11g)
- [Docker MongoDB Image](https://hub.docker.com/_/mongo)

This setup provides a local environment for experimenting with Oracle GoldenGate to compare the performance of different capture modes. Adjust configurations based on your specific requirements and monitoring tools available.
