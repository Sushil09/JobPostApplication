package com.sjsushil09.restfulwebservice.daoservice;

import com.sjsushil09.restfulwebservice.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostService extends JpaRepository<JobPost,Integer> {
}
