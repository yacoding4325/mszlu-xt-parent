package com.mszlu.xt.admin.domain;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mszlu.xt.admin.domain.repository.TopicDomainRepository;
import com.mszlu.xt.admin.model.TopicModel;
import com.mszlu.xt.admin.params.TopicParam;
import com.mszlu.xt.common.enums.TopicType;
import com.mszlu.xt.common.model.CallResult;
import com.mszlu.xt.common.model.ListPageModel;
import com.mszlu.xt.pojo.Subject;
import com.mszlu.xt.pojo.Topic;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;

import java.util.*;

/**
 * @Author yaCoding
 * @create 2022-12-30 下午 12:27
 */

public class TopicDomain {

    private TopicParam topicParam;

    private TopicDomainRepository topicDomainRepository;

    public TopicDomain(TopicParam topicParam, TopicDomainRepository topicDomainRepository) {
        this.topicParam = topicParam;
        this.topicDomainRepository = topicDomainRepository;
    }

    private String displayTopicType(Integer topicType) {
        switch (TopicType.valueOfCode(topicType)){
            case FILL_BLANK:
                return "填空题";
            case RADIO:
                return "单选题";
            case QA:
                return "问答题";
            case MUL_CHOICE:
                return "多选题";
            case JUDGE:
                return "判断题";
            default:return "";
        }
    }

    private String displayTopicSubject(List<Subject> subjectList, Long subject) {
        for (Subject subject1 : subjectList){
            if (subject1.getId().equals(subject)){
                return subject1.getSubjectName() +" "+ subject1.getSubjectGrade() +" "+ subject1.getSubjectTerm();
            }
        }
        return "";
    }

    private TopicModel copy(Topic topic){
        TopicModel topicModel = new TopicModel();
        BeanUtils.copyProperties(topic,topicModel);
        return topicModel;
    }
    private List<TopicModel> copyList(List<Topic> topicList){
        if (topicList == null){
            return null;
        }
        List<Subject> subjectList = this.topicDomainRepository.createSubjectDomain(null).findAllSubjectList();
        List<TopicModel> topicModelList = new ArrayList<>();
        for (Topic topic : topicList){
            TopicModel model = copy(topic);
            model.setTopicTypeStr(displayTopicType(topic.getTopicType()));
            model.setSubjectStr(displayTopicSubject(subjectList,topic.getTopicSubject()));
            model.setCreateTime(new DateTime(topic.getCreateTime()).toString("yyyy-MM-dd HH:mm:ss"));
            model.setLastUpdateTime(new DateTime(topic.getLastUpdateTime()).toString("yyyy-MM-dd HH:mm:ss"));
            topicModelList.add(model);
        }
        return topicModelList;
    }

    public CallResult<Object> findTopicList() {
        int page = this.topicParam.getPage();
        int pageSize = this.topicParam.getPageSize();
        String topicTitle = topicParam.getTopicTitle();
        Long subjectId = topicParam.getSubjectId();
        Page<Topic> topicList = this.topicDomainRepository.findPage(page,pageSize,topicTitle,subjectId);
        List<TopicModel> topicModelList = copyList(topicList.getRecords());
        ListPageModel<TopicModel> listModel = new ListPageModel<>();
        listModel.setList(topicModelList);
        listModel.setSize(topicList.getTotal());
        return CallResult.success(listModel);
    }

    public TopicModel findTopicByTitle() {
        Topic topic = this.topicDomainRepository.findTopicByTitle(this.topicParam.getTopicTitle());
        return copy(topic);
    }

    public CallResult<Object> updateTopic() {
        Topic topic = new Topic();
        BeanUtils.copyProperties(this.topicParam,topic);
        this.topicDomainRepository.update(topic);
        return CallResult.success();
    }

    public CallResult<Object> saveTopic() {
        Topic topic = new Topic();
        BeanUtils.copyProperties(this.topicParam,topic);
        this.topicDomainRepository.save(topic);
        return CallResult.success();
    }

}
