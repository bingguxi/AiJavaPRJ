package kopo.poly.service.impl;

import kopo.poly.dto.NlpDTO;
import kopo.poly.service.INlpService;
import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class NlpService implements INlpService {
    Komoran komoran = new Komoran(DEFAULT_MODEL.FULL); // 학습용 데이터는 가장 큰 파일 사용
    @Override
    public NlpDTO getPlainText(String text) {

        log.info(this.getClass().getName() + ".getPlainText Start!");

        KomoranResult komoranResult = komoran.analyze(text); // 인식된 문자열 분석 결과

        String result = komoranResult.getPlainText(); // 모든 단어마다 품사 태깅

        NlpDTO rDTO = new NlpDTO();
        rDTO.setResult(result); // 얘가 세터! 세터하면 얘를 자동으로 만들어주징

        log.info(this.getClass().getName() + ".getPlainText End!");

        return rDTO;
    }

    @Override
    public NlpDTO getNouns(String text) {

        log.info(this.getClass().getName() + ".getNouns Start!");

        KomoranResult komoranResult = komoran.analyze(text); // 인식된 문자열 분석 결과

        List<String> nouns = komoranResult.getNouns(); // NNG, NNP 품사만 추출함

        NlpDTO rDTO = new NlpDTO();
        rDTO.setNouns(nouns); // 롬복에 세터라는 애가 자동생성해서 만들어준 함수?

        log.info(this.getClass().getName() + ".getNouns End!");

        return rDTO;
    }
}
