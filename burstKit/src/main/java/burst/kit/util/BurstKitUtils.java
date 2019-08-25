package burst.kit.util;

import burst.kit.entity.response.http.attachment.MultiOutAttachmentResponse;
import burst.kit.entity.response.http.attachment.TransactionAttachmentAndAppendagesResponse;
import com.google.gson.GsonBuilder;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.atomic.AtomicReference;

@SuppressWarnings("WeakerAccess")
public final class BurstKitUtils {
    private static final AtomicReference<String> endpoint = new AtomicReference<>("poc");
    private static final AtomicReference<String> addressPrefix = new AtomicReference<>("POC");
    private static final AtomicReference<String> valueSuffix = new AtomicReference<>("POC");

    public static GsonBuilder buildGson(GsonBuilder builder) {
        return builder
                // Response entities
                .registerTypeAdapter(TransactionAttachmentAndAppendagesResponse.class, TransactionAttachmentAndAppendagesResponse.SERIALIZER)
                .registerTypeAdapter(TransactionAttachmentAndAppendagesResponse.class, TransactionAttachmentAndAppendagesResponse.DESERIALIZER)
                .registerTypeAdapter(MultiOutAttachmentResponse.MultiOutRecipient.class, MultiOutAttachmentResponse.MultiOutRecipient.SERIALIZER)
                .registerTypeAdapter(MultiOutAttachmentResponse.MultiOutRecipient.class, MultiOutAttachmentResponse.MultiOutRecipient.DESERIALIZER)
                ;
    }

    public static String getEndpoint() {
        return endpoint.get();
    }

    public static void setEndpoint(String newEndpoint) {
        if (newEndpoint != null) {
            endpoint.set(newEndpoint);
        }
    }

    public static String getAddressPrefix() {
        return addressPrefix.get();
    }

    public static void setAddressPrefix(String newAddressPrefix) {
        if (newAddressPrefix != null) {
            addressPrefix.set(newAddressPrefix);
        }
    }

    public static String getValueSuffix() {
        return valueSuffix.get();
    }

    public static void setValueSuffix(String newValueSuffix) {
        if (newValueSuffix != null) {
            valueSuffix.set(newValueSuffix);
        }
    }

    public static Scheduler defaultBurstNodeServiceScheduler() {
        return Schedulers.io();
    }

    public static GsonBuilder buildGson() {
        return buildGson(new GsonBuilder());
    }
}
