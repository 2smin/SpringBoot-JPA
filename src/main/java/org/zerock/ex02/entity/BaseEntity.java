package org.zerock.ex02.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass //테이블을 생성하지 않는다. 이 클래스를 상속한 클래스만 테이블 만들자
@EntityListeners(value = { AuditingEntityListener.class }) //엔티티객체의 변화를 감지하는 리스너 JPA내에서 객체의 생성/변경을 감지함
@Getter
abstract class BaseEntity {

    @CreatedDate //엔티티 생성 시간을 처리한다
    @Column(name = "regdate" , updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate //최종수정시간 처리
    @Column(name = "moddate")
    private LocalDateTime modDate;

}
