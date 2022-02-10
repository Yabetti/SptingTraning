package sgtg.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import sgtg.model.MST_USERDto;

@Repository
public class MST_USERRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * ユーザID存在チェック
     * @param USER_ID
     * @return Dto(ユーザ情報)
     */
    public List<MST_USERDto> CheckUserID(MST_USERDto dto) {

        String sql = "SELECT * FROM MST_USER WHERE USER_ID = :USER_ID";

        // Rowmapper
        try {
            List<MST_USERDto> R_mst_userdtolist = jdbcTemplate.query(
                    sql,
                    new BeanPropertyRowMapper<MST_USERDto>(MST_USERDto.class));
            return R_mst_userdtolist;

        } catch (EmptyResultDataAccessException e) {
            // 検索結果0件
            return null;
        } catch (Exception e) {
            throw e;
        }
    }
}
