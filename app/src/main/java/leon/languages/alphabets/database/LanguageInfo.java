package leon.languages.alphabets.database;

import leon.languages.alphabets.R;

/**
 * Created by Leon on 8/14/2015.
 */
public class LanguageInfo {

    /**
     * Todo: Info should be integrated into database at later time
     */

    public static String[] LANGUAGE_NAMES_IN_NATIVE = {
            "العربي", "Deutsch", "English", "Español", "Français", "אָלֶף־בֵּית עִבְרִי", "Ελληνικά", "한국어", "हिंढी", "日本語", "Pусский", "中文(简体)", "中文(繁体)"
    };
    public static String[] LANGUAGE_NAME_IDENTIFIERS = {"Arabic", "German", "English", "Spanish",
            "French", "Hebrew", "Greek", "Korean", "Hindi", "Japanese",
            "Russian", "SimplifiedChinese", "TraditionalChinese"};

    public static String[] languageNamesInEnglish = {"Arabic", "German", "English", "Spanish",
            "French", "Greek", "Korean", "Hindi", "Japanes4e",
            "Russian", "SimplifiedChinese", "TraditionalChinese"};

    public static int[] nationalFlagImageUrls = {
            R.drawable.nationalflag_arabic,
            R.drawable.nationalflag_germany,
            R.drawable.nationalflag_britain,
            R.drawable.nationalflag_spain,
            R.drawable.nationalflag_france,
            R.drawable.nationalflag_israel,
            R.drawable.nationalflag_greece,
            R.drawable.nationalflag_korean,
            R.drawable.nationalflag_india,
            R.drawable.nationalflag_japan,
            R.drawable.nationalflag_russia,
            R.drawable.nationalflag_china,
            R.drawable.congratulations
    };

    /**
     * Arabic alphabet: right to left problem
     */
    public static String[] hebrewAlphabetRightToLeft = {
            "ה", "ד", "ג", "ב", "א",
            "י", "ט", "ח", "ז", "ו",
            "ם", "מ", "ל", "ל", "כ",
            "פ", "ע", "ס", "ן", "נ",
            "ר", "ק", "ץ", "צ", "ף",
            " ", "ﭏ", "•", "ת", "ש"
    };

    public static String[] arabicAlphabetLeftToRight = {
            "ا", "ب", "ت", "ث", "ج",
            "ح", "خ", "د", "ذ", "ر",
            "ز", "س", "ش", "ص", "ض",
            "ط", "ظ", "ع", "غ", "ف",
            "ق", "ك", "ل", "م", "ن",
            "ه", "و", "ي"
    };
    public static String[] arabicAlphabetRightToLeft = {
            "ج", "ث ", "ت", "ب", "ا",
            "ر", "ذ", "د", "خ", "ح",
            "ض", "ص", "ش", "س", "ز",
            "ف", "غ", "ع", "ظ", "ط",
            "ن", "م", "ل", "ك", "ق",
            " ", " ", "ي", "و", "ه"
    };

    public static String[] arabicAlphabetWithDifferentForms = {
//            "F", "M", "I", "I",
            "ـا", "ـا", "ا", "ا",
            "ـب", "ـبـ", "بـ", "ب",
            "ـت", "ـتـ", "تـ", "ت",
            "ـث", "ـثـ", "ثـ", "ث",
            "ـج", "ـجـ", "جـ", "ج",
            "ـح", "ـحـ", "حـ", "ح",
            "ـخ", "ـخـ", "خـ", "خ",
            "ـد", "ـد", "د", "د",
            "ـذ", "ـذ", "ذ", "ذ",
            "ـر", "ـر", "ر", "ر",
            "ـز", "ـز", "ز", "ز",
            "ـس", "ـسـ", "سـ", "س",
            "ـش", "ـشـ", "شـ", "ش",
            "ـص", "ـصـ", "صـ", "ص",
            "ـض", "ـضـ", "ضـ", "ض",
            "ـط", "ـطـ", "طـ", "ط",
            "ـظ", "ـظـ", "ظـ", "ظ",
            "ـع", "ـعـ", "عـ", "ع",
            "ـغ", "ـغـ", "غـ", "غ",
            "ـف", "ـفـ", "فـ", "ف",
            "ـق", "ـقـ", "قـ", "قـ",
            "ـك", "ـكـ", "كـ", "ك",
            "ـل", "ـلـ", "لـ", "ل",
            "ـم", "ـمـ", "مـ", "م",
            "ـن", "ـنـ", "نـ", "ن",
            "ـه", "ـهـ", "هـ", "ه",
            "ـو", "ـو", "و", "و",
            "ـي", "ـيـ", "يـ", "ي"
    };


    public static String[] russianAlphabetUppercase = {
            "А", "Б", "В", "Г", "Д", "Е", "Ё",
            " Ж", "З", "И", "Й", "К", "Л", "М ",
            "Н", "О", "П", "Р", "С", "Т", "У",
            "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ъ",
            "Ы", "Ь", "Э", "Ю", "Я"
    };
    public static String[] russianAlphabetLowercase = {
            "а", "б", " в", "г", "д", "е", "ё",
            "ж", "з", "и", "й", "к", "л", "м",
            "н", "о", "п", "р", "с", "т", "у",
            "ф", "х", "ц", "ч", "ш", "щ", "ъ",
            "ы", "ь", "э", "ю", "я"
    };
    public static String[] russianVowelsLetters = {
            "A/a", "E/e", "Ё/ё", "И/и", "O/o",
            "Y/y", "Ы/ы", "Э/э", "Ю/ю", "Я/я"
    };
    public static String[] russianConsonantLetters = {
            "Б/б", "В/в", "Г/г", "Д/д", "Ж/ж", "З/з", "Й/й",
            "К/к", "Л/л", "М/м", "Н/н", "П/п", "P/p", "С/с",
            "Т/т", "Ф/ф", "Х/х", "Ц/ц", "Ч/ч", "Ш/ш", "Щ/щ"
    };

    public static String[] spanishAlphabetUppercase = {
            "A", "B", "C", "CH", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "LL", "M", "N", "Ñ", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z"
    };
    public static String[] spanishAlphabetLowercase = {
            "a", "b", "c", "ch", "d", "e", "f", "g", "h", "i",
            "j", "k", "l", "ll", "m", "n", "ñ", "o", "p", "q", "r",
            "s", "t", "u", "v", "w", "x", "y", "z"
    };

    public static String[] englishAlphabetUppercase = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"
    };
    public static String[] englishAlphabetLowercase = {
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z"
    };
    public static String[] germanAlphabetUppercase = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z", "Ä", "Ö", "Ü"
    };
    public static String[] germanAlphabetLowercase = {
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z", "ä", "ö", "ü", "ß"
    };

    public static String[] greekAlphabetUppercase = {
            "Α", "Β", "Γ", "Δ", "Ε", "Ζ", "Η",
            "Θ", "Ι", "Κ", "Λ", "Μ", "Ν", "Ξ",
            "Ο", "Π", "Ρ", "Σ", "Τ", "Υ", "Φ",
            "Χ", "Ψ", "Ω"
    };

    public static String[] greekAlphabetLowercase = {
            "α", "β", "γ", "δ", "ε", "ζ", "η",
            "θ", "ι", "κ", "λ", "μ", "ν", "ξ",
            "ο", "π", "ρ", "σ/ς", "τ", "υ", "φ",
            "χ", "ψ", "ω"
    };


    public static String[] frenchAlphabetUppercase = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };

    public static String[] frenchAlphabetLowercase = {
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
            "é", "è", "ç", "ë", "ò", "ô", "ö", "ù", "à", "â"
    };


    public static String[] koreanVowelLetters = {
            "ㅏ", "ㅐ", "ㅒ", "ㅑ", "ㅓ",
            "ㅔ", "ㅖ", "ㅕ", "ㅗ", "ㅘ",
            "ㅙ", "ㅚ", "ㅛ", "ㅜ", "ㅝ",
            "ㅞ", "ㅟ", "ㅠ", "ㅡ", "ㅢ",
            "ㅣ"
    };

    /*
     *       e1: ɛ
     *       e2: ə
     */
    public static int[] koreanVowelsAudioUrls = {
            R.raw.korean_vowel_a, R.raw.korean_vowel_e1, R.raw.korean_vowel_je1, R.raw.korean_vowel_ja, R.raw.korean_vowel_e2,
            R.raw.korean_vowel_e, R.raw.korean_vowel_je, R.raw.korean_vowel_je2, R.raw.korean_vowel_o, R.raw.korean_vowel_wa,
            R.raw.korean_vowel_we1, R.raw.korean_vowel_ue, R.raw.korean_vowel_jo, R.raw.korean_vowel_u, R.raw.korean_vowel_we2,
            R.raw.korean_vowel_we, R.raw.korean_vowel_y, R.raw.korean_vowel_ju, R.raw.korean_vowel_w, R.raw.korean_vowel_wi,
            R.raw.korean_vowel_i
    };

    public static String[] koreanConsonantLetters = {
            "ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ",
            "ㄹ", "ㅁ", "ㅂ", "ㅃ", "ㅅ",
            "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ",
            "ㅋ", "ㅌ", "ㅍ", "ㅎ"
    };

    public static int[] koreanConsonantsAudioUrls = {
            R.raw.korean_consonant_g, R.raw.korean_consonant_g, R.raw.korean_consonant_n, R.raw.korean_consonant_t, R.raw.korean_consonant_tt,
            R.raw.korean_consonant_l, R.raw.korean_consonant_m, R.raw.korean_consonant_p, R.raw.korean_consonant_pp, R.raw.korean_consonant_s,
            R.raw.korean_consonant_ss, R.raw.korean_consonant_ng, R.raw.korean_consonant_z, R.raw.korean_consonant_zz, R.raw.korean_consonant_c,
            R.raw.korean_consonant_k, R.raw.korean_consonant_kk, R.raw.korean_consonant_n, R.raw.korean_consonant_h
    };

    public static String[] koreanDoubleConsonantLetters = {
            "ㄳ", "ㅄ", "ㄵ", "ㄽ", "ㄾ",
            "ㄻ", "ㄺ", "ㄼ", "ㄿ", "ㄶ",
            "ㅀ"
    };

    public static int[] koreanCompoundConsonantsAudioUrls = {
            R.raw.korean_consonant_g, R.raw.korean_consonant_p, R.raw.korean_consonant_n, R.raw.korean_consonant_l, R.raw.korean_consonant_l,
            R.raw.korean_consonant_l, R.raw.korean_consonant_g, R.raw.korean_consonant_l, R.raw.korean_consonant_l, R.raw.korean_consonant_n,
            R.raw.korean_consonant_l
    };

    public static String[] hindiVowelLetters = {
            "अ", "आ", "इ", "ई", "उ", "ऊ",
            "ओ", "औ", "ए", "ऐ", "ऋ"
    };

    public static int[] hindiVowelsAudioUrl = {
            R.raw.hindi_vowel_a, R.raw.hindi_vowel_aa, R.raw.hindi_vowel_i, R.raw.hindi_vowel_ii,
            R.raw.hindi_vowel_u, R.raw.hindi_vowel_uu, R.raw.hindi_vowel_o, R.raw.hindi_vowel_au,
            R.raw.hindi_vowel_e, R.raw.hindi_vowel_ai, R.raw.hindi_vowel_ri
    };

    public static String[] hindiConsonantLetters = {
            "क", "ख", "ग", "घ", "ङ",
            "च", "छ", "ज", "झ", "ञ",
            "ट", "ठ", "ड", "ढ", "ण",
            "त", "भ", "द", "ध", "न",
            "प", "फ", "ब", "भ", "म",
            "य", "र", "ल", "व", "श",
            "ष", "स", "ह"
    };

    public static int[] hindiConsonantsAnimationUrl = {
            R.drawable.hindi_b_animation, R.drawable.hindi_bh_animation, R.drawable.hindi_b_animation, R.drawable.hindi_b_animation, R.drawable.hindi_b_animation,
            R.drawable.hindi_b_animation, R.drawable.hindi_b_animation, R.drawable.hindi_b_animation, R.drawable.hindi_b_animation, R.drawable.hindi_b_animation,
            R.drawable.hindi_b_animation, R.drawable.hindi_b_animation, R.drawable.hindi_b_animation, R.drawable.hindi_b_animation, R.drawable.hindi_b_animation,
            R.drawable.hindi_b_animation, R.drawable.hindi_b_animation, R.drawable.hindi_b_animation, R.drawable.hindi_b_animation, R.drawable.hindi_b_animation,
            R.drawable.hindi_b_animation, R.drawable.hindi_b_animation, R.drawable.hindi_b_animation, R.drawable.hindi_b_animation, R.drawable.hindi_b_animation,
            R.drawable.hindi_b_animation, R.drawable.hindi_b_animation, R.drawable.hindi_b_animation, R.drawable.hindi_b_animation, R.drawable.hindi_b_animation,
            R.drawable.hindi_b_animation, R.drawable.hindi_b_animation, R.drawable.hindi_b_animation
    };

    public static int[] hindiConsonantsAudioUrl = {
            R.raw.hindi_k, R.raw.hindi_kh, R.raw.hindi_g, R.raw.hindi_gh, R.raw.hindi_ng,
            R.raw.hindi_c, R.raw.hindi_ch, R.raw.hindi_j, R.raw.hindi_jh, R.raw.hindi_ny,
            R.raw.hindi_tt, R.raw.hindi_tth, R.raw.hindi_dd, R.raw.hindi_ddh, R.raw.hindi_nn,
            R.raw.hindi_t, R.raw.hindi_th, R.raw.hindi_d, R.raw.hindi_dh, R.raw.hindi_n,
            R.raw.hindi_p, R.raw.hindi_ph, R.raw.hindi_b, R.raw.hindi_bh, R.raw.hindi_m,
            R.raw.hindi_y, R.raw.hindi_r, R.raw.hindi_l, R.raw.hindi_v, R.raw.hindi_sha,
            R.raw.hindi_shh, R.raw.hindi_sa, R.raw.hindi_h
    };

    public static String[] hiragana = {
            "あ", "い", "う", "え", "お",
            "か", "き", "く", "け", "こ",
            "さ", "し", "す", "せ", "そ",
            "た", "ち", "つ", "て", "と",
            "な", "に", "ぬ", "ね", "の",
            "は", "ひ", "ふ", "へ", "ほ",
            "ま", "み", "む", "め", "も",
            "や", " ", "ゆ", " ", "よ",
            "ら", "り", "る", "れ", "ろ",
            "わ", " ", " ", " ", "を",
            "ん"
    };

    public static String[] katagana = {
            "ア", "イ", "ウ", "エ", "オ",
            "カ", "キ", "ク", "ケ", "コ",
            "サ", "シ", "す", "セ", "ソ",
            "タ", "チ", "ツ", "テ", "ト",
            "ナ", "二", "ヌ", "ネ", "ノ",
            "ハ", "ヒ", "フ", "ヘ", "ホ",
            "マ", "ミ", "ム", "メ", "モ",
            "ヤ", " ", "ユ", " ", "ヨ",
            "ラ", "リ", "ル", "レ", "ロ",
            "ワ", " ", " ", " ", "ヲ",
            "ン"
    };

    public static int[] japaneseAudioUrl = {
            R.raw.japanese_a, R.raw.japanese_i, R.raw.japanese_u, R.raw.japanese_e, R.raw.japanese_o,
            R.raw.japanese_ka, R.raw.japanese_ki, R.raw.japanese_ku, R.raw.japanese_ke, R.raw.japanese_ko,
            R.raw.japanese_sa, R.raw.japanese_si, R.raw.japanese_su, R.raw.japanese_se, R.raw.japanese_so,
            R.raw.japanese_ta, R.raw.japanese_ti, R.raw.japanese_tu, R.raw.japanese_te, R.raw.japanese_to,
            R.raw.japanese_na, R.raw.japanese_ni, R.raw.japanese_nu, R.raw.japanese_ne, R.raw.japanese_no,
            R.raw.japanese_ha, R.raw.japanese_hi, R.raw.japanese_hu, R.raw.japanese_he, R.raw.japanese_ho,
            R.raw.japanese_ma, R.raw.japanese_mi, R.raw.japanese_mu, R.raw.japanese_me, R.raw.japanese_mo,
            R.raw.japanese_ya, R.raw.japanese_i, R.raw.japanese_yu, R.raw.japanese_e, R.raw.japanese_yo,
            R.raw.japanese_ra, R.raw.japanese_ri, R.raw.japanese_ru, R.raw.japanese_re, R.raw.japanese_ro,
            R.raw.japanese_wa, R.raw.japanese_i, R.raw.japanese_u, R.raw.japanese_e, R.raw.japanese_wo,
            R.raw.japanese_nn
    };

    public static class imageUrlHolders {
        public static int[] hiraganaImageUrl = {
                R.drawable.japanese_hiragana_a, R.drawable.japanese_hiragana_i, R.drawable.japanese_hiragana_u, R.drawable.japanese_hiragana_e, R.drawable.japanese_hiragana_o,
                R.drawable.japanese_hiragana_ka, R.drawable.japanese_hiragana_ki, R.drawable.japanese_hiragana_ku, R.drawable.japanese_hiragana_ke, R.drawable.japanese_hiragana_ko,
                R.drawable.japanese_hiragana_sa, R.drawable.japanese_hiragana_si, R.drawable.japanese_hiragana_su, R.drawable.japanese_hiragana_se, R.drawable.japanese_hiragana_so,
                R.drawable.japanese_hiragana_ta, R.drawable.japanese_hiragana_ti, R.drawable.japanese_hiragana_tu, R.drawable.japanese_hiragana_te, R.drawable.japanese_hiragana_to,
                R.drawable.japanese_hiragana_na, R.drawable.japanese_hiragana_ni, R.drawable.japanese_hiragana_nu, R.drawable.japanese_hiragana_ne, R.drawable.japanese_hiragana_no,
                R.drawable.japanese_hiragana_ha, R.drawable.japanese_hiragana_hi, R.drawable.japanese_hiragana_hu, R.drawable.japanese_hiragana_he, R.drawable.japanese_hiragana_ho,
                R.drawable.japanese_hiragana_ma, R.drawable.japanese_hiragana_mi, R.drawable.japanese_hiragana_mu, R.drawable.japanese_hiragana_me, R.drawable.japanese_hiragana_mo,
                R.drawable.japanese_hiragana_ya, R.drawable.japanese_noimage, R.drawable.japanese_hiragana_yu, R.drawable.japanese_noimage, R.drawable.japanese_hiragana_yo,
                R.drawable.japanese_hiragana_ra, R.drawable.japanese_hiragana_ri, R.drawable.japanese_hiragana_ru, R.drawable.japanese_hiragana_re, R.drawable.japanese_hiragana_ro,
                R.drawable.japanese_hiragana_wa, R.drawable.japanese_noimage, R.drawable.japanese_noimage, R.drawable.japanese_noimage, R.drawable.japanese_hiragana_wo,
                R.drawable.japanese_hiragana_nn,
        };

        public static int[] hindiConsonantsImageUrls = {
                R.drawable.hindi_k, R.drawable.hindi_kh, R.drawable.hindi_g, R.drawable.hindi_gh, R.drawable.hindi_ng,
                R.drawable.hindi_c, R.drawable.hindi_ch, R.drawable.hindi_j, R.drawable.hindi_jh, R.drawable.hindi_ny,
                R.drawable.hindi_tt, R.drawable.hindi_tth, R.drawable.hindi_dd, R.drawable.hindi_ddh, R.drawable.hindi_nn,
                R.drawable.hindi_t, R.drawable.hindi_th, R.drawable.hindi_d, R.drawable.hindi_dh, R.drawable.hindi_n,
                R.drawable.hindi_p, R.drawable.hindi_ph, R.drawable.hindi_b, R.drawable.hindi_bh, R.drawable.hindi_m,
                R.drawable.hindi_y, R.drawable.hindi_r, R.drawable.hindi_l, R.drawable.hindi_v, R.drawable.hindi_sha,
                R.drawable.hindi_shh, R.drawable.hindi_sa, R.drawable.hindi_h
        };
    }


}
