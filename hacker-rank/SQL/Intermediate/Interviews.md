Q.

contest_id, hacker_id, name, total_submissions의 합, total_accepted_submissions, total_views, tital_unique_views의 합 을 출력하라.

각각의 콘테스트는 contest_id로 정렬된다.

4개의 합이 0인 것은 제외시켜라.

*Contests*

|Column|Type|
|------|----|
|contest_id|Integer|
|hacker_id|Integer|
|name|String|

*Colleges*
|Column|Type|
|------|----|
|college_id|Integer|
|contest_id|Integer|

*Challenges*

|Column|Type|
|------|----|
|challenge_id|Integer|
|college_id|Integer|

*View_stats*

|Column|Type|
|------|----|
|challenge_id|Integer|
|total_views|Integer|
|total_unique_views|Integer|

*Submission_Stats*

|Column|Type|
|------|----|
|challenge_id|Integer|
|total_submissions|Integer|
|total_accepted_submissions|Integer|


A.
```SQL
SELECT
    CT.CONTEST_ID,
    CT.HACKER_ID,
    CT.NAME,
    SUM(TTB.TOTAL_SUBMISSIONS),
    SUM(TTB.TOTAL_ACCEPTED_SUBMISSIONS),
    SUM(TTA.TOTAL_VIEWS),
    SUM(TTA.TOTAL_UNIQUE_VIEWS)
FROM CONTESTS CT
INNER JOIN COLLEGES CE ON CT.CONTEST_ID = CE.CONTEST_ID
INNER JOIN CHALLENGES CG ON CE.COLLEGE_ID = CG.COLLEGE_ID
LEFT JOIN (
    SELECT
        CHALLENGE_ID CHALLENGE_ID,
        SUM(NVL(TOTAL_VIEWS, 0)) TOTAL_VIEWS,
        SUM(NVL(TOTAL_UNIQUE_VIEWS, 0)) TOTAL_UNIQUE_VIEWS
    FROM VIEW_STATS
    GROUP BY CHALLENGE_ID) TTA ON CG.CHALLENGE_ID = TTA.CHALLENGE_ID
LEFT JOIN (
    SELECT
        CHALLENGE_ID CHALLENGE_ID,
        SUM(NVL(TOTAL_SUBMISSIONS, 0)) TOTAL_SUBMISSIONS,
        SUM(NVL(TOTAL_ACCEPTED_SUBMISSIONS, 0)) TOTAL_ACCEPTED_SUBMISSIONS
    FROM SUBMISSION_STATS
    GROUP BY CHALLENGE_ID) TTB ON CG.CHALLENGE_ID = TTB.CHALLENGE_ID
GROUP BY CT.CONTEST_ID, CT.HACKER_ID, CT.NAME
HAVING (SUM(TTB.TOTAL_SUBMISSIONS) + SUM(TTB.TOTAL_ACCEPTED_SUBMISSIONS) + 
    SUM(TTA.TOTAL_VIEWS) + SUM(TTA.TOTAL_UNIQUE_VIEWS)) != 0
ORDER BY CT.CONTEST_ID;
```

처음에는 `VIEW_STATS`에 대한 값들을 구하기 위한 서브스키마와, `SUBMISSION_STATS`를 구하기 위한 서브스키마를 합쳐도 될 거라 생각했다.

실제로 합쳐서 서브스키마를 구성했을 때, `VIEW_STATS`와 `SUBMISSION_STATS` 두 테이블 간의 연관성은 전혀 없는데 컬럼 `CHALLENGE_ID` 로 묶었을 때 중복되는 값이 발생해 원하는 합의 데이터를 출력하는데 제한이 된다.
