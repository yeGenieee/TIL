package com.web.community.domain;

import com.web.community.domain.enums.BoardType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table
public class Board implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 스프링 부트 1.x 에서는 기본 키 할당 전략이 IDENTITY이지만,  2.x 부터는 TABLE로 변경되어, 명확히 IDENTITY로 지정하지 않으면 한 테이블에서만 시퀀스가 관리되는 현상이 발생함
    private Long idx; // @GeneratedValue : 기본 키가 자동으로 할당되도록 설정하는 어노테이션 --> IDENTITY는 pk 할당 전략 중 하나로, 키 생성을 DB에 위임함

    @Column
    private String title;

    @Column
    private String subTitle;

    @Column
    private String content;

    @Column
    @Enumerated(EnumType.STRING) // Enum 타입 매핑용 어노테이션 (자바 enum과 DB 데이터 변환을 지원함-실제로는 자바 enum형이지만 DB String으로 변환해 저장)
    private BoardType boardType;

    @Column
    private LocalDateTime createdDateTime;

    @Column
    private LocalDateTime updatedDateTime;

    @OneToOne(fetch = FetchType.LAZY) // User 도메인과 1:1 매핑 (실제로 DB에 저장될 때는, User 객체가 저장되는 것이 아닌 User의 idx(pk)가 저장됨
    private User user; // fetch는 EAGER와 LAZY가 있음 (EAGER는 Board 도메인 조회 시 즉시 관련 User 객체를 함꼐 조회, LAZY는 User 객체가 실제로 사용될 때 조회)

    @Builder
    public Board(String title, String subTitle, String content, BoardType boardType,
                 LocalDateTime createdDateTime, LocalDateTime updatedDateTime, User user) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.boardType = boardType;
        this.createdDateTime = createdDateTime;
        this.updatedDateTime = updatedDateTime;
        this.user = user;
    }

}
