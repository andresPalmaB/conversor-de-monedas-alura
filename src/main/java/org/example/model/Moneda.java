package org.example.model;

import java.text.Normalizer;

public enum Moneda {
    USD("Estados Unidos"),
    AED("Emiratos Árabes Unidos"),
    AFN("Afganistán"),
    ALL("Albania"),
    AMD("Armenia"),
    ANG("Antillas Neerlandesas"),
    AOA("Angola"),
    ARS("Argentina"),
    AUD("Australia"),
    AWG("Aruba"),
    AZN("Azerbaiyán"),
    BAM("Bosnia-Herzegovina"),
    BBD("Barbados"),
    BDT("Bangladesh"),
    BGN("Bulgaria"),
    BHD("Bahrein"),
    BIF("Burundi"),
    BMD("Bermudas"),
    BND("Brunei"),
    BOB("Bolivia"),
    BRL("Brasil"),
    BSD("Bahamas"),
    BTN("Bután"),
    BWP("Botswana"),
    BYN("Bielorrusia"),
    BZD("Belice"),
    CAD("Canadá"),
    CDF("República Democrática del Congo"),
    CHF("Suiza"),
    CLP("Chile"),
    CNY("China"),
    COP("Colombia"),
    CRC("Costa Rica"),
    CUP("Cuba"),
    CVE("Cabo Verde"),
    CZK("República Checa"),
    DJF("Yibuti"),
    DKK("Dinamarca"),
    DOP("República Dominicana"),
    DZD("Argelia"),
    EGP("Egipto"),
    ERN("Eritrea"),
    ETB("Etiopía"),
    EUR("Unión Europea"),
    FJD("Fiyi"),
    FKP("Islas Malvinas"),
    FOK("Islas Feroe"),
    GBP("Reino Unido"),
    GEL("Georgia"),
    GGP("Guernsey"),
    GHS("Ghana"),
    GIP("Gibraltar"),
    GMD("Gambia"),
    GNF("Guinea"),
    GTQ("Guatemala"),
    GYD("Guyana"),
    HKD("Hong Kong"),
    HNL("Honduras"),
    HRK("Croacia"),
    HTG("Haití"),
    HUF("Hungría"),
    IDR("Indonesia"),
    ILS("Israel"),
    IMP("Isla de Man"),
    INR("India"),
    IQD("Irak"),
    IRR("Irán"),
    ISK("Islandia"),
    JEP("Jersey"),
    JMD("Jamaica"),
    JOD("Jordania"),
    JPY("Japón"),
    KES("Kenia"),
    KGS("Kirguistán"),
    KHR("Camboya"),
    KID("Kiribati"),
    KMF("Comoras"),
    KRW("Corea del Sur"),
    KWD("Kuwait"),
    KYD("Islas Caimán"),
    KZT("Kazajistán"),
    LAK("Laos"),
    LBP("Líbano"),
    LKR("Sri Lanka"),
    LRD("Liberia"),
    LSL("Lesoto"),
    LYD("Libia"),
    MAD("Marruecos"),
    MDL("Moldavia"),
    MGA("Madagascar"),
    MKD("Macedonia del Norte"),
    MMK("Myanmar"),
    MNT("Mongolia"),
    MOP("Macao"),
    MRU("Mauritania"),
    MUR("Mauricio"),
    MVR("Maldivas"),
    MWK("Malawi"),
    MXN("México"),
    MYR("Malasia"),
    MZN("Mozambique"),
    NAD("Namibia"),
    NGN("Nigeria"),
    NIO("Nicaragua"),
    NOK("Noruega"),
    NPR("Nepal"),
    NZD("Nueva Zelanda"),
    OMR("Omán"),
    PAB("Panamá"),
    PEN("Perú"),
    PGK("Papúa Nueva Guinea"),
    PHP("Filipinas"),
    PKR("Pakistán"),
    PLN("Polonia"),
    PYG("Paraguay"),
    QAR("Catar"),
    RON("Rumanía"),
    RSD("Serbia"),
    RUB("Rusia"),
    RWF("Ruanda"),
    SAR("Arabia Saudita"),
    SBD("Islas Salomón"),
    SCR("Seychelles"),
    SDG("Sudán"),
    SEK("Suecia"),
    SGD("Singapur"),
    SHP("Santa Elena"),
    SLE("Sierra Leona"),
    SLL("Sierra Leona"),
    SOS("Somalia"),
    SRD("Surinam"),
    SSP("Sudán del Sur"),
    STN("Santo Tomé y Príncipe"),
    SYP("Siria"),
    SZL("Suazilandia"),
    THB("Tailandia"),
    TJS("Tayikistán"),
    TMT("Turkmenistán"),
    TND("Túnez"),
    TOP("Tonga"),
    TRY("Turquía"),
    TTD("Trinidad y Tobago"),
    TVD("Tuvalu"),
    TWD("Taiwán"),
    TZS("Tanzania"),
    UAH("Ucrania"),
    UGX("Uganda"),
    UYU("Uruguay"),
    UZS("Uzbekistán"),
    VES("Venezuela"),
    VND("Vietnam"),
    VUV("Vanuatu"),
    WST("Samoa"),
    XAF("África Central"),
    XCD("Caribe Oriental"),
    XDR("Derechos Especiales de Giro"),
    XOF("África Occidental"),
    XPF("Franco CFP"),
    YER("Yemen"),
    ZAR("Sudáfrica"),
    ZMW("Zambia"),
    ZWL("Zimbabue"),
    SALIR("Salir");

    private final String pais;

    Moneda(String pais) {
        this.pais = pais;
    }

    public String getPais() {
        return pais;
    }

    public static Moneda getMonedaPorPais(String pais){

        for (Moneda moneda : Moneda.values()){

            String normalizacionPaisMoneda = Normalizer.normalize(moneda.getPais(), Normalizer.Form.NFD);
            String normalizacionPaisParametro = Normalizer.normalize(pais, Normalizer.Form.NFD);

            if (normalizacionPaisMoneda.equalsIgnoreCase(normalizacionPaisParametro)){
                return moneda;
            }
        }
        return null;
    }

    public static void imprimirListaMonedas(){

        for (Moneda moneda : Moneda.values()){

            if (moneda.equals(Moneda.SALIR)){
                continue;
            }

            System.out.println(moneda.getPais() + ": " + moneda);

        }
    }
}
