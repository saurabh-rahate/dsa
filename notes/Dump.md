Yes, Oracle GoldenGate can read data from an Oracle database and publish it to both Kafka and MongoDB in a single read. This is achievable by configuring Oracle GoldenGate with multiple handlers. The Kafka Handler can be used to publish messages to Kafka, while the MongoDB Handler can be used to replicate the data into MongoDB.

For more detailed information on setting up these handlers and ensuring they work concurrently, refer to the official documentation on the [Kafka Handler](https://docs.oracle.com/en/middleware/goldengate/big-data/19.1/gadbd/using-kafka-handler.html) and [MongoDB Handler](https://docs.oracle.com/en/middleware/goldengate/big-data/19.1/gadbd/using-mongodb-handler.html).

Additionally, Oracle's official documentation provides guidance on configuring Oracle GoldenGate for Big Data, including how to set up and use these handlers effectively for real-time data integration into multiple systems【76†source】【77†source】【78†source】.
