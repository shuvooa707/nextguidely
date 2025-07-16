package org.current.nextguidely.seeder;

import org.current.nextguidely.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
public class LanguageSeeder {
    
    @Autowired
    private LanguageService languageService;
    
    public void run() {
        
        IntStream
                .range(0, 100)
                .forEach(i -> {
                    List<String> languages = List.of("Afrikaans", "Albanian", "Amharic", "Arabic", "Armenian", "Assamese", "Azerbaijani", "Bangla",
                            "Basque", "Belarusian", "Bosnian", "Bulgarian", "Burmese", "Catalan", "Cebuano", "Chinese",
                            "Croatian", "Czech", "Danish", "Dutch", "English", "Estonian", "Filipino", "Finnish", "French",
                            "Georgian", "German", "Greek", "Gujarati", "Haitian Creole", "Hausa", "Hawaiian", "Hebrew",
                            "Hindi", "Hmong", "Hungarian", "Icelandic", "Igbo", "Indonesian", "Irish", "Italian", "Japanese",
                            "Javanese", "Kannada", "Kazakh", "Khmer", "Kinyarwanda", "Korean", "Kurdish", "Kyrgyz", "Lao",
                            "Latin", "Latvian", "Lithuanian", "Luxembourgish", "Macedonian", "Malagasy", "Malay", "Malayalam",
                            "Maltese", "Maori", "Marathi", "Mongolian", "Nepali", "Norwegian", "Nyanja", "Odia", "Pashto",
                            "Persian", "Polish", "Portuguese", "Punjabi", "Romanian", "Russian", "Samoan", "Scots Gaelic",
                            "Serbian", "Sesotho", "Shona", "Sindhi", "Sinhala", "Slovak", "Slovenian", "Somali", "Spanish",
                            "Sundanese", "Swahili", "Swedish", "Tajik", "Tamil", "Tatar", "Telugu", "Thai", "Turkish",
                            "Turkmen", "Ukrainian", "Urdu", "Uyghur", "Uzbek", "Vietnamese", "Welsh", "Xhosa", "Yiddish",
                            "Yoruba", "Zulu");
                    try {
                        languages.forEach(language->{
                            languageService.createLanguage(language);
                        });
                    } catch (Exception e) {
                    
                    }
                });
    }
}
