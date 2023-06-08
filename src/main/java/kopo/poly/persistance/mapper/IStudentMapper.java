package kopo.poly.persistance.mapper;

import kopo.poly.dto.StudentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IStudentMapper {

    /* 학생 등록 쿼리 */
    void insertStudent(StudentDTO pDTO) throws Exception;

    /* 학생 전체 조회 쿼리 */
    List<StudentDTO> getStudentList() throws Exception;

    /* 학생이 존재하는지 체크하기 위해 학생 아이디를 기준으로 1명 조회하기 쿼리 */
    StudentDTO getStudent(StudentDTO pDTO) throws Exception;

    /* 학생 삭제 쿼리 / 회원 삭제는 PK로 설정된 USER_ID의 값을 기준으로 삭제함 */
    void deleteStudent(StudentDTO pDTO) throws Exception;
}
