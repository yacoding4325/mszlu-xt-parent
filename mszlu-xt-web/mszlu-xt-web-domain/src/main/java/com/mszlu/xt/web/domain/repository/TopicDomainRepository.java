package com.mszlu.xt.web.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mszlu.xt.pojo.Topic;
import com.mszlu.xt.pojo.UserPractice;
import com.mszlu.xt.web.dao.TopicMapper;
import com.mszlu.xt.web.dao.data.TopicDTO;
import com.mszlu.xt.web.domain.*;
import com.mszlu.xt.web.model.params.*;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author yaCoding
 * @create 2023-01-02 下午 10:20
 */

@Component
public class TopicDomainRepository {

    @Autowired
    private CourseDomainRepository courseDomainRepository;

    @Autowired
    private UserCourseDomainRepository userCourseDomainRepository;

    @Autowired
    private UserHistoryDomainRepository userHistoryDomainRepository;

    @Autowired
    private UserPracticeDomainRepository userPracticeDomainRepository;

    @Autowired
    private TopicMapper topicMapper;

    @Autowired
    private UserProblemDomainRepository userProblemDomainRepository;

    @Autowired
    private SubjectDomainRepository subjectDomainRepository;

    public TopicDomain createDomain(TopicParam topicParam) {
        return new TopicDomain(this,topicParam);
    }

    public CourseDomain createCourseDomain(CourseParam courseParam) {
        return courseDomainRepository.createDomain(courseParam);
    }

    public UserCourseDomain createUserCourseDomain(UserCourseParam userCourseParam) {
        return userCourseDomainRepository.createDomain(userCourseParam);
    }

    public UserHistoryDomain createUserHistoryDomain(UserHistoryParam userHistoryParam) {
        return userHistoryDomainRepository.createDomain(userHistoryParam);
    }

    public UserPracticeDomain createUserPracticeDomain(UserPracticeParam userPracticeParam) {
        return userPracticeDomainRepository.createDomain(userPracticeParam);
    }

    public TopicDTO findTopicAnswer(Long topicId,Long userId, Long userHistoryId) {
        TopicDTO topicDTO = new TopicDTO();
        Topic topic = this.topicMapper.selectById(topicId);
        UserPractice userPractice = this.userPracticeDomainRepository.createDomain(null).findUserPracticeByTopicId(userId,topicId,userHistoryId);
        BeanUtils.copyProperties(topic,topicDTO);
        topicDTO.setUserAnswer(userPractice.getUserAnswer());
        topicDTO.setPStatus(userPractice.getPStatus());
        return topicDTO;
//        return this.topicMapper.findTopicAnswer(topicId,userId,userHistoryId);
    }

    public SubjectDomain createSubjectDomain(SubjectParam subjectParam) {
        return this.subjectDomainRepository.createDomain(subjectParam);
    }

    public Topic findTopicById(Long topicId) {
        return topicMapper.selectById(topicId);
    }

    public List<Long> findTopicRandom(Long subjectId, List<Integer> subjectUnitList) {
        LambdaQueryWrapper<Topic> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(Topic::getTopicSubject,subjectId);
        if (CollectionUtils.isNotEmpty(subjectUnitList)){
            queryWrapper.in(Topic::getSubjectUnit,subjectUnitList);
        }
        queryWrapper.last("order by RAND() limit 50");
        queryWrapper.select(Topic::getId);
        List<Topic> topicList = topicMapper.selectList(queryWrapper);
        return topicList.stream().map(Topic::getId).collect(Collectors.toList());
    }

    public UserProblemDomain createUserProblem(UserProblemParam userProblemParam) {
        return userProblemDomainRepository.createDomain(userProblemParam);
    }

}
