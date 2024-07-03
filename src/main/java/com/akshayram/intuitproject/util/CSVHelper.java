package com.akshayram.intuitproject.util;

import com.akshayram.intuitproject.customer.Customer;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {
//    public static String TYPE = "text/csv";
//    static String[] HEADERs = {
//    "Index",	"Customer Id", "First Name",	"Last Name", "Company",	"City",	"Country",
//            "Phone 1",	"Phone 2","Email",	"Subscription Date", "Website"
//    };
//    public static boolean hasCSVFormat(MultipartFile file) {
//
//        if (!TYPE.equals(file.getContentType())) {
//            return false;
//        }
//
//        return true;
//    }
//
//    public static List<Customer> csvToTutorials(InputStream is) {
//        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//             CSVParser csvParser = new CSVParser(fileReader,
//                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
//
//            List<Tutorial> tutorials = new ArrayList<Tutorial>();
//
//            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
//
//            for (CSVRecord csvRecord : csvRecords) {
//                Tutorial tutorial = new Tutorial(
//                        Long.parseLong(csvRecord.get("Id")),
//                        csvRecord.get("Title"),
//                        csvRecord.get("Description"),
//                        Boolean.parseBoolean(csvRecord.get("Published"))
//                );
//
//                tutorials.add(tutorial);
//            }
//
//            return tutorials;
//        } catch (IOException e) {
//            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
//        }
//    }

}
