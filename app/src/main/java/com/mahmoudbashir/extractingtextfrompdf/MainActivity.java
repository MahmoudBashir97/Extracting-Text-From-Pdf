package com.mahmoudbashir.extractingtextfrompdf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class MainActivity extends AppCompatActivity {

    // creating variables for
    // button and text view.
    private Button extractPDFBtn;
    private TextView extractedTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing variables for button and text view.
        extractedTV = findViewById(R.id.idPDFTV);
        extractPDFBtn = findViewById(R.id.idBtnExtract);

        extractPDFBtn.setOnClickListener(view -> extractpdf());

    }

    private void extractpdf() {
        try {

            String extractedText ="";
            PdfReader reader = new PdfReader("res/raw/mpdf.pdf");
            int numberOfPages = reader.getNumberOfPages();
            for (int i = 0; i<numberOfPages;i++){
                extractedText = extractedText + PdfTextExtractor.getTextFromPage(reader,i+1).trim()+"\n";
            }
            extractedTV.setText(extractedText);
            reader.close();
        }catch (Exception e) {
            // for handling error while extracting the text file.
            extractedTV.setText("Error found is : \n" + e);
        }
    }
}