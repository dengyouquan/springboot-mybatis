package com.hand.infra.mapper;

import com.hand.domain.entity.Actor;
import com.hand.domain.entity.Film;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@CacheNamespace
public interface FilmMapper extends Mapper<Film> {
    @Select("select * from actor where actor_id in (select actor_id from film_actor where film_id = #{filmId})")
    @Results({
            @Result(id=true,column="actor_id",property="actorId"),
            @Result(column="first_name",property="firstName"),
            @Result(column="last_update",property="lastUpdate"),
            @Result(column="last_name",property="lastName")
    })
    List<Actor> selectActors(Short filmId);

    @Select("select * from film a where a.film_id=#{filmId}")
    @Results({
            @Result(id=true,column="film_id",property="filmId"),
            @Result(column="title",property="title"),
            @Result(column="release_year",property="releaseYear"),
            @Result(column="language_id",property="languageId"),
            @Result(column="original_language_id",property="originalLanguageId"),
            @Result(column="rental_duration",property="rentalDuration"),
            @Result(column="rental_rate",property="rentalRate"),
            @Result(column="length",property="length"),
            @Result(column="replacement_cost",property="replacementCost"),
            @Result(column="rating",property="rating"),
            @Result(column="special_features",property="specialFeatures"),
            @Result(column="description",property="description"),
            @Result(column="last_update",property="lastUpdate"),
            @Result(column="film_id",property="actors",
                    many=@Many(
                            select="com.hand.infra.mapper.FilmMapper.selectActors",
                            fetchType=FetchType.EAGER
                    )
            )
    })
    Film findById(Short filmId);
}