package ch.hslu.oop.sw11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public final class IOStreamsDemo {

    private final Path workDir;
    private final String textFile = "oop-test.txt";
    private final String binFile = "oop-test.bin";
    private static final Logger LOG = LoggerFactory.getLogger(IOStreamsDemo.class);

    public IOStreamsDemo() {
        workDir = Paths.get(System.getenv("homepath"), "Desktop");
    }

    public IOStreamsDemo(String workDir) {
        this.workDir = Paths.get(workDir);
    }

    public Path getTextFilePath() {
        return Paths.get(workDir.toAbsolutePath().toString(), textFile);
    }

    public Path getBinFilePath() {
        return Paths.get(workDir.toAbsolutePath().toString(), binFile);
    }

    public void writeIntToFileAsByte(final int value, final String file) {
        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream(String.valueOf(this.getBinFilePath())))
        ) {
            LOG.info(String.format("DataOutputStream.writeInt(%s)", value));
            dos.writeInt(value);
        } catch (IOException e) {
            LOG.error(e.toString());
        }
    }

    public void writeStringToFileAsByte(final String value, final String file) {
        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream(file))) {

            LOG.info(String.format("DataOutputStream.writeUTF(\"%s\")", value));
            dos.writeUTF(value);

        } catch (IOException e) {
            LOG.error(e.toString());
        }
    }

    public byte[] readNBytesFromBinFile(final int byteCount, final String file) {
        byte[] bytes = {0x0};

        try (FileInputStream fis = new FileInputStream(file)) {
            bytes = fis.readNBytes(byteCount);

            StringBuilder hexString = new StringBuilder();
            for (byte b : bytes) {
                hexString.append(String.format("%02x", b)).append(" ");
            }

            LOG.info(String.format("FileInputStream.readNBytes(%s) -> %s", byteCount, Arrays.toString(bytes)));
            LOG.info(hexString.toString());
        } catch (IOException e) {
            LOG.error(e.toString());
        }

        return bytes;
    }

    public short readShortFromBinFile(final String file) {
        try (DataInputStream dis = new DataInputStream(
                new FileInputStream(file))
        ) {
            final short value = dis.readShort();
            LOG.info("DataInputStream.readShort() -> " + value);
            return value;
        } catch (IOException e) {
            LOG.error(e.toString());
        }
        return 0;
    }


    public void readIntFromBinFile(final String file) {
        try (DataInputStream dis = new DataInputStream(
                new FileInputStream(file))
        ) {
            final int value = dis.readInt();
            LOG.info("readInt() -> " + value);
            final String binString = Integer.toBinaryString(value);
            LOG.info(String.format("%s (%s)", binString, binString.length()));
        } catch (IOException e) {
            LOG.error(e.toString());
        }
    }

    public void readBoolFromBinFile(final String file) {
        try (DataInputStream dis = new DataInputStream(
                new FileInputStream(file))
        ) {
            final boolean value = dis.readBoolean();
            LOG.info("readBoolean() -> " + value);
        } catch (IOException e) {
            LOG.error(e.toString());
        }
    }


    public void readFile(final String file) {
        try (DataInputStream dis = new DataInputStream(
                new FileInputStream(file))
        ) {
            final String value = dis.readUTF();
            LOG.info(value);
        } catch (IOException e) {
            LOG.error(e.toString());
        }
    }

    public void writeFile(final String file) {
        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream(file))) {
//            dos.writeUTF("🤣");
            dos.writeUTF("joël🤣");
//            dos.writeInt(10);
//            dos.writeInt(-20);

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Methode um Text als UTF-8 in eine Datei zu schreiben (line-by-line)
     *
     * @param file Dateipfad.
     */
    public void writeTextFile(final String file) {
        try (PrintWriter pw = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(file),
                                StandardCharsets.UTF_8)));
        ) {
            pw.println("Euro € und Umlaute äöü - alles da!");
            pw.println("Plattformunabhängig fix mit UTF-8 encodiert!");
            pw.flush();
        } catch (IOException ioe) {
            LOG.error(ioe.getMessage(), ioe);
        }
    }

    /**
     * Methode um Text als UTF-8 aus einer Datei zu lesen (line-by-line)
     *
     * @param file Dateipfad.
     */
    public void readTextFile(final String file) {
        if (new File(file).exists()) {
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(file),
                            StandardCharsets.UTF_8))
            ) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException ioe) {
                LOG.error(ioe.getMessage(), ioe);
            }
        }
    }
}
