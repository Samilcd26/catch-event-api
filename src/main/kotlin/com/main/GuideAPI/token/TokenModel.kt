package com.main.GuideAPI.token

import com.main.GuideAPI.data.models.UserModel
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.*


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
data class TokenModel(
    @Id
    @GeneratedValue
    var id: Int? = null,

    @Column(unique = true)
    var token: String? = null,

    @Enumerated(EnumType.STRING)
    var tokenType: TokenType = TokenType.BEARER,

    var revoked: Boolean = false,
    var expired: Boolean = false,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: UserModel? = null,
)
