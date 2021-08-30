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

