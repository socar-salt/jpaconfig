# Jpa-config에 따른 도메인설계 예제

socar, socar-log에 대한 jpaconfig를 분류하여 각각 dataSource에 맞게 도메인 설계

## 구성
| class               | 설명               | 
|------------------------|--------------------|
| domain/socar/config/SocarJpaConfig | Socar용 JpaConfig    |
| domain/socar/config/SocarQuerydslRepositorySupport | socar용 RepositorySupport    |
| domain/socar/domain/admin | admin 테이블 엔티티    |
| domain/socar/domain/adminRepository | admin 테이블 레파지토리    |
| domain/socarlog/config/SocarJpaConfig | Socar-log용 JpaConfig    |
| domain/socarlog/domain/BondPaymentLog | BondPaymentLog 테이블 엔티티    |
| domain/socarlog/domain/BondPaymentLogRepository | BondPaymentLog 테이블 레파지토리    |
| domain/socarlog/domain/BondSmsmentLog | BondSmsLog 테이블 엔티티    |
| domain/socarlog/domain/BondSmsmentLogRepository | BondSmsLog 테이블 레파지토리    |


## Getting Start
업데이트 예정 (PR 코멘트 참고해주세요.)
