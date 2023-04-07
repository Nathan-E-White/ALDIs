package com.neptune.app;

// import org.checkerframework.checker.units.qual.A;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Objects;

/**
 * <h1>Main application class</h1>
 *
 */
@SpringBootApplication
@ComponentScan({"com.neptune.app.controller", "com.neptune.app.service"})
public class App {

    /**
     * @param args The program arguments
     */
    public static void main( String[] args ) {

        ItemCode code1, code2;
        Address addr1, addr2;

            try {
                /* Carrots, Bag */
                code1 = new ItemCode("18742194361","23648-2629265");
                addr1 = makeAddressFromCode(code1);

                /* Multicolored peppers, package */
                code2 = new ItemCode("45841631805","23648-26274165");
                addr2 = makeAddressFromCode(code2);

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }


        System.out.println( "Hello World!" );
        SpringApplication.run(App.class, args);
    }

    @NotNull
    @Contract("_ -> new")
    private static URL makeURLFromCodes(ItemCode code) throws MalformedURLException {
        String fname = MessageFormat.format(
                "store/items/item_{0}?v4_item_id=items_{1}",
                code.c1(),
                code.c2()
        );
        return new URL("https", "shop.aldi.us", -1, fname);
    }

    @NotNull
    @Contract(value = "_ -> new")
    private static Address makeAddressFromCode(ItemCode code) throws MalformedURLException {
        return new Address(makeURLFromCodes(code));
    }

    @SuppressWarnings("ClassCanBeRecord")
    static final class Address {
        private final URL addr;

        Address (URL addr) {this.addr = addr;}

        @SuppressWarnings("unused")
        public URL addr () {return addr;}

        @Override
        public boolean equals (Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            Address that = (Address) obj;
            return Objects.equals(this.addr, that.addr);
        }

        @Override
        public int hashCode () {
            return Objects.hash(addr);
        }

        @Override
        public String toString () {
            return "Address[" +
                    "addr=" + addr + ']';
        }
    }

    @SuppressWarnings("ClassCanBeRecord")
    static final class ItemCode {
        private final String c1;
        private final String c2;

        ItemCode (String c1, String c2) {
            this.c1 = c1;
            this.c2 = c2;
        }

        public String c1 () {return c1;}

        public String c2 () {return c2;}

        @Override
        public boolean equals (Object obj) {
            boolean result;
            if (obj == this) {
                result = true;
            } else if (obj == null || obj.getClass() != this.getClass()) {
                result = false;
            } else {
                ItemCode that = (ItemCode) obj;
                result = Objects.equals(this.c1, that.c1) &&
                        Objects.equals(this.c2, that.c2);
            }
            return result;
        }

        @Override
        public int hashCode () {
            return Objects.hash(c1, c2);
        }

        @Override
        public String toString () {
            return "ItemCode[" +
                    "c1=" + c1 + ", " +
                    "c2=" + c2 + ']';
        }
    }
}
