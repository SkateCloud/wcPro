import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class wordcountTest {

    @Test
    public void testwordcount() {

        String[] inputArr = new String[]{
        "software", "content-based", "Let’s", "night-", "“I", "TABLE1-2", "(see Box 3–2).8885d_c01_016",
        "r&XROzfA\"-'CR baZJOp_zCpOvQG&'lhlkiLEMIa_!IOuX&rtASt%iUagDn_bJ,",
        "r&XROzfA\"-' CR baZJOp _zCpOvQG&'lhlkiLE MIa_!IOuX&rtASt%iUagDn_bJvH;eAfOtRXQJBbosb)TjlgyqLlbNBUQOi-jLOujKI%ueLjPjPk-LplRD?sRFq)_rZWd",
        "r&XROz fA\"-'CR baZJOp_ zCpOv QG&'lhl kiLEMIa_!IOuX& rtASt  %iUagDn _bJvH ;eAfOtRXQJBbosb)TjlgyqLlbNBUQOi-jLOujKI%ueLjPjPk-LplRD?sRFq)_rZWd'vAnQcj'!?OOcz&z!!HALxac(HbZbmEpOJjg(dK%e&hE_US(\"G(asRFLGbmFs)u)rmSUyrIyjJjM",
        "OuX&rtASt%iUagDn_bJvH;eAfOtRXQJBbosb)TjlgyqLlbNBUQOi-jLOujKI%ueLjPjPk-LplRD?sRFq)_rZWd'vAnQcj'!?OOcz&z!!HALxac(HbZbmEpOJjg(dK%e&hE_US(\"G(asRFLGbmFs)u)rmSUyrIyjJjMHPeOCMfISw(eBe-hffFGanLaz!xO%TJJ&DsAycCijXjX'XKu_)Ez uf)LOZxhD%-; o&_yBIwVRHsds%GXO",
        "r&XRO zfA\"-' CR baZJO _zCpOvQG&'lhl kiLE MIa_! IOuX&rtASt%iUagDn_bJvH;eAfOtRXQJBbosb)TjlgyqLlbNBUQOi-jLOujKI%ueLjPjPk-LplRD?sRFq)_rZWd'vAnQcj'!?OOcz&z!!HALxac(HbZbmEpOJjg(dK%e&hE_US(\"G(asRFLGbmFs)u)rmSUyrIyjJjMHPeOCMfISw(eBe-hffFGanLaz!xO%TJJ&DsAycCijXjX'XKu_)Ez uf)LOZxhD%-; o&_yBIwVRHsds%GXOAqUPtopllSS\"rcZp'bLWErR?Vf!'RaM'OuVcQUi'qkJaIomm APxX%?GG-l&&BK&'arfAr'wFumjOq_K(xTX(SjPPDWT%df",
        "rtASt%iUagDn_bJvH;eAfOtRXQJBbosb)TjlgyqLlbNBUQOi-jLOujKI%ueLjPjPk-LplRD?sRFq)_rZWd'vAnQcj'!?OOcz&z!!HALxac(HbZbmEpOJjg(dK%e&hE_US(\"G(asRFLGbmFs)u)rmSUyrIyjJjMHPeOCMfISw(eBe-hffFGanLaz!xO%TJJ&DsAycCijXjX'XKu_)Ez uf)LOZxhD%-; o&_yBIwVRHsds%GXOAqUPtopllSS\"rcZp'bLWErR?Vf!'RaM'OuVcQUi'qkJaIomm APxX%?GG-l&&BK&'arfAr'wFumjOq_K(xTX(SjPPDWT%dfDbAwPm&dJjDPpj(Glfy ofcC%Ex?j%P'EtUlcW!;a-fMMQSz;VHSoMk-ICZy Q%eQLyisn",
        "rZWd'vAnQcj'!?OOcz&z!!HALxac(HbZbmEpOJjg(dK%e&hE_US(\"G(asRFLGbmFs)u)rmSUyrIyjJjMHPeOCMfISw(eBe-hffFGanLaz!xO%TJJ&DsAycCijXjX'XKu_)Ez uf)LOZxhD%-; o&_yBIwVRHsds%GXOAqUPtopllSS\"rcZp'bLWErR?Vf!'RaM'OuVcQUi'qkJaIomm APxX%?GG-l&&BK&'arfAr'wFumjOq_K(xTX(SjPPDWT%dfDbAwPm&dJjDPpj(Glfy ofcC%Ex?j%P'EtUlcW!;a-fMMQSz;VHSoMk-ICZy Q%eQLyisn\" IIm(",
        "r&XROzfA\"LOfAr'wFumjOq_K(xTX(SjPPDWT%dfDbAwPm&dJjDPpj(Glfy ofcC%Ex?j%P'EtUlcW!;a-fMMQSz;VHSoMk-ICZy Q%eQLyisn\" IIm(o",
        "r&XROzfA\"-'CR baZJOp_zCpOvQG&'lhlkiLEMIa_!IOuX&rtASt%iUagDn_bJvH;eAfOtRXQJBbosb)TjlgyqLlbNBUQOi-jLOujKI%ueLjPjPk-LplRD?sRFq)_rZWd'vAnQcj'!?OOcz&z!!HALxac(HbZbmEpOJjg(dK%e&hE_US(\"G(asRFLGbmFs)u)rmSUyrIyjJ(oJH(EIJ(KTA& msNvRN;j\"N(HuBHx!lc(tOAXDaROXesAkDPPbiEBpVd!tPfqyCkh\"V)Zb-Htt?zZXz;gvse?I'oeI",
        "b)TjlgyqLlbNBUQOi-jLOujKI%ueLjPjPk-LplRD?sRFq)_rZWd'vAnQcj'!?OOcz&",
        "r&XROzfA\"-'CR baZJOp_zCpOvQG&'lhlkiLEMIa_!IOuX&rtASt%iUagDn_bJvH;eAfOtRXQJBbosb)TjlgyqLlbNBUQOi-jLOujKI%ueLjPjPk-LplRD?sRFq)_rZWd'vAnQcj'!?OOcz&z!!HALxac(HbZbmEpOJjg(dK%e&hqkJaIomm APxX%?GG-",
        "V d p D g ; ? S W q O &   N S D N t ' ( X Q _ T g m K & x z x _ ! g t ) ) \" A M G ) t T N f f - u A % ; O X W i ' h - N S % R G & U d C w Z & Q u G u Z p k o - L p ? w m r & N x H e I X e ; C y b r L J D G j B c _ c L Z K J e G h K v H   z b",
        "e - R ; \" V % & g p P U a ! n w ? l \" ; y r s M U r S U L v d ) m H f _ t   a d h W D r \" - y ) e p _ q ( ? H   ) F m i ) n J h a R I c % q ( m M ! J q V i J - l S y S W i v h x N w h a G _ v & \"   S ?   j B a u W f ' & r z   & W Z i x M W X"} ;
        String[] answerArr = new String[] {
                "content-based 1","software 1","content-based 1","let 1\n" +
                "s 1","night- 1","i 1","table 1","box 1\n" +
                "c 1\n" +
                "d 1\n" +
                "see 1","bazjop 1\n" +
                "bj 1\n" +
                "cr 1\n" +
                "ioux 1\n" +
                "iuagdn 1\n" +
                "lhlkilemia 1\n" +
                "r 1\n" +
                "rtast 1\n" +
                "xrozfa 1\n" +
                "zcpovqg 1","bazjop 1\n" +
                "bjvh 1\n" +
                "cr 1\n" +
                "eafotrxqjbbosb 1\n" +
                "ioux 1\n" +
                "iuagdn 1\n" +
                "lhlkile 1\n" +
                "mia 1\n" +
                "r 1\n" +
                "rtast 1\n" +
                "rzwd 1\n" +
                "srfq 1\n" +
                "tjlgyqllbnbuqoi-jloujki 1\n" +
                "ueljpjpk-lplrd 1\n" +
                "xrozfa 1\n" +
                "zcpovqg 1","asrflgbmfs 1\n" +
                "bazjop 1\n" +
                "bjvh 1\n" +
                "cr 1\n" +
                "dk 1\n" +
                "e 1\n" +
                "eafotrxqjbbosb 1\n" +
                "fa 1\n" +
                "g 1\n" +
                "halxac 1\n" +
                "hbzbmepojjg 1\n" +
                "he 1\n" +
                "ioux 1\n" +
                "iuagdn 1\n" +
                "kilemia 1\n" +
                "lhl 1\n" +
                "oocz 1\n" +
                "qg 1\n" +
                "r 1\n" +
                "rmsuyriyjjjm 1\n" +
                "rtast 1\n" +
                "rzwd 1\n" +
                "srfq 1\n" +
                "tjlgyqllbnbuqoi-jloujki 1\n" +
                "u 1\n" +
                "ueljpjpk-lplrd 1\n" +
                "us 1\n" +
                "vanqcj 1\n" +
                "xroz 1\n" +
                "z 1\n" +
                "zcpov 1","asrflgbmfs 1\n" +
                "bjvh 1\n" +
                "dk 1\n" +
                "dsayccijxjx 1\n" +
                "e 1\n" +
                "eafotrxqjbbosb 1\n" +
                "ebe-hfffganlaz 1\n" +
                "ez 1\n" +
                "g 1\n" +
                "gxo 1\n" +
                "halxac 1\n" +
                "hbzbmepojjg 1\n" +
                "he 1\n" +
                "iuagdn 1\n" +
                "lozxhd 1\n" +
                "o 1\n" +
                "oocz 1\n" +
                "oux 1\n" +
                "rmsuyriyjjjmhpeocmfisw 1\n" +
                "rtast 1\n" +
                "rzwd 1\n" +
                "srfq 1\n" +
                "tjj 1\n" +
                "tjlgyqllbnbuqoi-jloujki 1\n" +
                "u 1\n" +
                "ueljpjpk-lplrd 1\n" +
                "uf 1\n" +
                "us 1\n" +
                "vanqcj 1\n" +
                "xku 1\n" +
                "xo 1\n" +
                "ybiwvrhsds 1\n" +
                "z 1","apxx 1\n" +
                "arfar 1\n" +
                "asrflgbmfs 1\n" +
                "bazjo 1\n" +
                "bjvh 1\n" +
                "bk 1\n" +
                "blwerr 1\n" +
                "cr 1\n" +
                "df 1\n" +
                "dk 1\n" +
                "dsayccijxjx 1\n" +
                "e 1\n" +
                "eafotrxqjbbosb 1\n" +
                "ebe-hfffganlaz 1\n" +
                "ez 1\n" +
                "g 1\n" +
                "gg-l 1\n" +
                "gxoaquptopllss 1\n" +
                "halxac 1\n" +
                "hbzbmepojjg 1\n" +
                "he 1\n" +
                "ioux 1\n" +
                "iuagdn 1\n" +
                "k 1\n" +
                "kile 1\n" +
                "lhl 1\n" +
                "lozxhd 1\n" +
                "mia 1\n" +
                "o 1\n" +
                "oocz 1\n" +
                "ouvcqui 1\n" +
                "qkjaiomm 1\n" +
                "r 1\n" +
                "ram 1\n" +
                "rczp 1\n" +
                "rmsuyriyjjjmhpeocmfisw 1\n" +
                "rtast 1\n" +
                "rzwd 1\n" +
                "sjppdwt 1\n" +
                "srfq 1\n" +
                "tjj 1\n" +
                "tjlgyqllbnbuqoi-jloujki 1\n" +
                "u 1\n" +
                "ueljpjpk-lplrd 1\n" +
                "uf 1\n" +
                "us 1\n" +
                "vanqcj 1\n" +
                "vf 1\n" +
                "wfumjoq 1\n" +
                "xku 1\n" +
                "xo 1\n" +
                "xro 1\n" +
                "xtx 1\n" +
                "ybiwvrhsds 1\n" +
                "z 1\n" +
                "zcpovqg 1\n" +
                "zfa 1","a-fmmqsz 1\n" +
                "apxx 1\n" +
                "arfar 1\n" +
                "asrflgbmfs 1\n" +
                "bjvh 1\n" +
                "bk 1\n" +
                "blwerr 1\n" +
                "dfdbawpm 1\n" +
                "djjdppj 1\n" +
                "dk 1\n" +
                "dsayccijxjx 1\n" +
                "e 1\n" +
                "eafotrxqjbbosb 1\n" +
                "ebe-hfffganlaz 1\n" +
                "eqlyisn 1\n" +
                "etulcw 1\n" +
                "ex 1\n" +
                "ez 1\n" +
                "g 1\n" +
                "gg-l 1\n" +
                "glfy 1\n" +
                "gxoaquptopllss 1\n" +
                "halxac 1\n" +
                "hbzbmepojjg 1\n" +
                "he 1\n" +
                "iuagdn 1\n" +
                "j 1\n" +
                "k 1\n" +
                "lozxhd 1\n" +
                "o 1\n" +
                "ofcc 1\n" +
                "oocz 1\n" +
                "ouvcqui 1\n" +
                "p 1\n" +
                "q 1\n" +
                "qkjaiomm 1\n" +
                "ram 1\n" +
                "rczp 1\n" +
                "rmsuyriyjjjmhpeocmfisw 1\n" +
                "rtast 1\n" +
                "rzwd 1\n" +
                "sjppdwt 1\n" +
                "srfq 1\n" +
                "tjj 1\n" +
                "tjlgyqllbnbuqoi-jloujki 1\n" +
                "u 1\n" +
                "ueljpjpk-lplrd 1\n" +
                "uf 1\n" +
                "us 1\n" +
                "vanqcj 1\n" +
                "vf 1\n" +
                "vhsomk-iczy 1\n" +
                "wfumjoq 1\n" +
                "xku 1\n" +
                "xo 1\n" +
                "xtx 1\n" +
                "ybiwvrhsds 1\n" +
                "z 1","a-fmmqsz 1\n" +
                "apxx 1\n" +
                "arfar 1\n" +
                "asrflgbmfs 1\n" +
                "bk 1\n" +
                "blwerr 1\n" +
                "dfdbawpm 1\n" +
                "djjdppj 1\n" +
                "dk 1\n" +
                "dsayccijxjx 1\n" +
                "e 1\n" +
                "ebe-hfffganlaz 1\n" +
                "eqlyisn 1\n" +
                "etulcw 1\n" +
                "ex 1\n" +
                "ez 1\n" +
                "g 1\n" +
                "gg-l 1\n" +
                "glfy 1\n" +
                "gxoaquptopllss 1\n" +
                "halxac 1\n" +
                "hbzbmepojjg 1\n" +
                "he 1\n" +
                "iim 1\n" +
                "j 1\n" +
                "k 1\n" +
                "lozxhd 1\n" +
                "o 1\n" +
                "ofcc 1\n" +
                "oocz 1\n" +
                "ouvcqui 1\n" +
                "p 1\n" +
                "q 1\n" +
                "qkjaiomm 1\n" +
                "ram 1\n" +
                "rczp 1\n" +
                "rmsuyriyjjjmhpeocmfisw 1\n" +
                "rzwd 1\n" +
                "sjppdwt 1\n" +
                "tjj 1\n" +
                "u 1\n" +
                "uf 1\n" +
                "us 1\n" +
                "vanqcj 1\n" +
                "vf 1\n" +
                "vhsomk-iczy 1\n" +
                "wfumjoq 1\n" +
                "xku 1\n" +
                "xo 1\n" +
                "xtx 1\n" +
                "ybiwvrhsds 1\n" +
                "z 1","a-fmmqsz 1\n" +
                "dfdbawpm 1\n" +
                "djjdppj 1\n" +
                "eqlyisn 1\n" +
                "etulcw 1\n" +
                "ex 1\n" +
                "glfy 1\n" +
                "iim 1\n" +
                "j 1\n" +
                "k 1\n" +
                "lofar 1\n" +
                "o 1\n" +
                "ofcc 1\n" +
                "p 1\n" +
                "q 1\n" +
                "r 1\n" +
                "sjppdwt 1\n" +
                "vhsomk-iczy 1\n" +
                "wfumjoq 1\n" +
                "xrozfa 1\n" +
                "xtx 1","asrflgbmfs 1\n" +
                "bazjop 1\n" +
                "bjvh 1\n" +
                "cr 1\n" +
                "dk 1\n" +
                "e 1\n" +
                "eafotrxqjbbosb 1\n" +
                "eij 1\n" +
                "g 1\n" +
                "gvse 1\n" +
                "halxac 1\n" +
                "hbzbmepojjg 1\n" +
                "he 1\n" +
                "hubhx 1\n" +
                "i 1\n" +
                "ioux 1\n" +
                "iuagdn 1\n" +
                "j 1\n" +
                "kta 1\n" +
                "lc 1\n" +
                "lhlkilemia 1\n" +
                "msnvrn 1\n" +
                "n 1\n" +
                "oei 1\n" +
                "ojh 1\n" +
                "oocz 1\n" +
                "r 1\n" +
                "rmsuyriyjj 1\n" +
                "rtast 1\n" +
                "rzwd 1\n" +
                "srfq 1\n" +
                "tjlgyqllbnbuqoi-jloujki 1\n" +
                "toaxdaroxesakdppbiebpvd 1\n" +
                "tpfqyckh 1\n" +
                "u 1\n" +
                "ueljpjpk-lplrd 1\n" +
                "us 1\n" +
                "v 1\n" +
                "vanqcj 1\n" +
                "xrozfa 1\n" +
                "z 1\n" +
                "zb-htt 1\n" +
                "zcpovqg 1\n" +
                "zzxz 1","b 1\n" +
                "oocz 1\n" +
                "rzwd 1\n" +
                "srfq 1\n" +
                "tjlgyqllbnbuqoi-jloujki 1\n" +
                "ueljpjpk-lplrd 1\n" +
                "vanqcj 1","apxx 1\n" +
                "bazjop 1\n" +
                "bjvh 1\n" +
                "cr 1\n" +
                "dk 1\n" +
                "e 1\n" +
                "eafotrxqjbbosb 1\n" +
                "gg- 1\n" +
                "halxac 1\n" +
                "hbzbmepojjg 1\n" +
                "hqkjaiomm 1\n" +
                "ioux 1\n" +
                "iuagdn 1\n" +
                "lhlkilemia 1\n" +
                "oocz 1\n" +
                "r 1\n" +
                "rtast 1\n" +
                "rzwd 1\n" +
                "srfq 1\n" +
                "tjlgyqllbnbuqoi-jloujki 1\n" +
                "ueljpjpk-lplrd 1\n" +
                "vanqcj 1\n" +
                "xrozfa 1\n" +
                "z 1\n" +
                "zcpovqg 1",
                "g 8\n" +
                        "x 6\n" +
                        "d 5\n" +
                        "n 5\n" +
                        "t 5\n" +
                        "z 5\n" +
                        "c 4\n" +
                        "h 4\n" +
                        "k 4\n" +
                        "u 4\n" +
                        "w 4\n" +
                        "b 3\n" +
                        "e 3\n" +
                        "j 3\n" +
                        "l 3\n" +
                        "m 3\n" +
                        "o 3\n" +
                        "p 3\n" +
                        "q 3\n" +
                        "r 3\n" +
                        "s 3\n" +
                        "a 2\n" +
                        "f 2\n" +
                        "i 2\n" +
                        "v 2\n" +
                        "y 1\n"
        };

        for (int i = 0 ; i < 20 ; ++ i) {
            wordcount.main(new String[]{"input.txt"});
            writeFile(inputArr[i]);
            String answer = readFile("result.txt");
            String str = answerArr[i];
            assertEquals(str, answer);
        }
    }

    private String readFile(String path) { // 读文件
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(path));
            return new String(encoded, "UTF-8");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void writeFile(String answer) {
        try (FileWriter fout = new FileWriter("input.txt")) {
            fout.append(answer);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return;
    }

}