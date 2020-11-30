package com.itrecruitmentapi.controller.image.DTO;

import com.itrecruitmentapi.controller.account.DTO.AccountDTO;
import com.itrecruitmentapi.controller.account.DTO.CandidateDTO;
import com.itrecruitmentapi.entity.AccountEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ImageDTO {

    private Integer imageId;

    private String imageUrl;

    private boolean isAvatar;

    private boolean isBanner;

    private boolean isThumbnail;

    private AccountDTO accountDTO;
}
