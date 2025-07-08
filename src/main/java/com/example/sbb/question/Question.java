package com.example.sbb.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.example.sbb.answer.Answer;
import com.example.sbb.user.SiteUser;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Question {
    @Id // id 속성을 기본키로 지정하는 에너테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 데이터를 저장할 때 자동으로 1씩 증가하여 저장됨, GenerationType.IDENTITY 속성이 없으면 @GeneratedValue 에너테이션이 지정된 모든 속성에 번호를 차례로 생성하므로, 일정한 고유 번호를 가질 수 없음
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

    @ManyToOne
    private SiteUser author;

    private LocalDateTime modifyDate;

    @ManyToMany
    Set<SiteUser> voter;
}
