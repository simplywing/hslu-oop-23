package ch.hslu.oop.sw11;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class IOStreamsDemoTest {

    private static final Logger LOG = LoggerFactory.getLogger(IOStreamsDemoTest.class);

    @Test
    void writeIntToFileAsByte() {
        var demo = new IOStreamsDemo();
        var binFile = demo.getBinFilePath().toString();

        demo.writeIntToFileAsByte(8192, binFile);
        byte[] bytes = demo.readNBytesFromBinFile(4, binFile);

        assertEquals(32, bytes[2]);
    }

    @Test
    void writeMultipleDataTypesToFileAsByte() {
        var demo = new IOStreamsDemo();
        var binFile = String.valueOf(demo.getBinFilePath());

        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream(binFile))
        ) {
        } catch (IOException e) {
            LOG.error(e.toString());
        }

        demo.writeIntToFileAsByte(8192, binFile);
        byte[] bytes = demo.readNBytesFromBinFile(4, binFile);

        assertEquals(32, bytes[2]);
    }

    @Test
    void writeStringToFileAsByte() {
        var demo = new IOStreamsDemo();
        var binFile = demo.getBinFilePath().toString();

        demo.writeStringToFileAsByte("Joël 🤣", binFile);
        short byteCount = demo.readShortFromBinFile(binFile);

        byte[] bytes = demo.readNBytesFromBinFile(byteCount + 2, binFile);
    }
}