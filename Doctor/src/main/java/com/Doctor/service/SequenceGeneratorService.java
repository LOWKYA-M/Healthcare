package com.Doctor.service;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import com.Doctor.entity.DbSequence;


@Service
public class SequenceGeneratorService {


    @Autowired
    private MongoOperations mongoOperations;



    public long generateSequence(String seqName) {

        Query query = new Query(Criteria.where("id").is(seqName));
        Update update=new Update().inc("seq",1);
        DbSequence counter = mongoOperations.findAndModify(query,update, FindAndModifyOptions.options().returnNew(true).upsert(true), DbSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;

    }
}
