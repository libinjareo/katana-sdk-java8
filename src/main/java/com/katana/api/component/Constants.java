package com.katana.api.component;

/**
 * Created by juan on 1/10/16.
 */
public class Constants {

    public static final String VERSION_PATTERN = "[a-zA-Z0-9*.,_\\-]+";

    public static final String SERVICE = "service";
    public static final String MIDDLEWARE = "middleware";
    public static final String REQUEST_STRING = "request";
    public static final String WORKERS = "workers";
    public static final String TCP = "tcp";
    public static final String IPC = "ipc";

    public static final String WORKER_ENDPOINT = "ipc://workers";

    public static final int VOID_BYTE = 0x00;
    public static final int CALL_BYTE = 0x01;
    public static final int FILE_BYTE = 0x02;
    public static final int TRANSACTION_BYTE = 0x03;
    public static final int DOWNLOAD_BYTE = 0x04;

    //Patterns
    public static final String WORKER_ENDPOINT_STRING = "%s_%s";
    public static final String TCP_HOST_STRING = "%s://%s:%s";
    public static final String IPC_HOST_STRING = "%s://%s";
    public static final String KATANA_DEFAULT_SOCKET_STRING = "@katana-%s-%s-%s";

    //Status
    public static final String INTERNAL_SERVER_ERROR_STATUS = "500 Internal Server Error";

    //Data types
    public static final String TYPE_BOOLEAN = "boolean";
    public static final String TYPE_INTEGER = "integer";
    public static final String TYPE_FLOAT = "float";
    public static final String TYPE_STRING = "string";
    public static final String TYPE_ARRAY = "array";
    public static final String TYPE_OBJECT = "object";

    //Array types
    public static final String ARRAY_TYPE_CSV = "csv";

    //Relations
    public static final String RELATION_ONE = "one";

    //Protocols
    public static final String KATANA_PROTOCOL_HTTP = "urn:katana:protocol:http";

    private Constants() {
        // private constructor to block the instantiation of this object
    }

}
