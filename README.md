## Gilbert Kristian - Adpro A - 2306274951
---

# Module 5: Java Profiling
### JMeter Report & Test Results :

### Endpoint `/all-student`:
Test Result JMeter :
<img src="/image/jmeter-all-student.png">

Before Optimization JMeter :
<img src="/image/before-all-student.png">

After Optimization JMeter :
<img src="/image/after-all-student.png">

Test Result JMeter Post-Profiling:
<img src="/image/jmeter-after-all-student.png">

Execution Time `getAllStudentWithCourses()` from Intellij Profiler:

| Before    | After    | Diff Percentage |
|-----------|--------  |-----------------|
| 14,277 ms | 1,183 ms | 91.71%          |

### Endpoint `/all-student-name`:
Test Result JMeter :
<img src="/image/jmeter-all-student-name.png">

Before Optimization JMeter :
<img src="image/before-all-student.png">

After Optimization JMeter :
<img src="/image/after-all-student-name.png">

Test Result JMeter Post-Profiling:
<img src="/image/jmeter-after-all-student-name.png">

Execution Time `joinStudentNames()` from Intellij Profiler:

| Before | After    | Diff Percentage |
|--------|--------  | --------------- |
| 1,008 ms | 169 ms | 83.23%          |

### Endpoint `/highest-gpa`:
Test Result JMeter :
<img src="/image/jmeter-highest-gpa.png">

Before Optimization JMeter :
<img src="/image/before-highest-gpa.png">

After Optimization JMeter :
<img src="/image/after-highest-gpa.png">

Test Result JMeter Post-Profiling:
<img src="/image/jmeter-after-highest-gpa.png">

Execution Time `findStudentWithHighestGpa()` from Intellij Profiler:

| Before | After | Diff Percentage |
|--------|-------| --------------- |
| 182 ms | 48 ms | 73.62%          |

**Conclusion** :

The results indicate an improvement in performance based on the recorded sample times. The execution time was reduced after optimization compared to the initial execution time. This suggests that the optimization process was effective, utilizing JMeter and IntelliJ Profiler for analysis.

---
## Reflection:

## 1. What is the difference between the approach of performance testing with JMeter and profiling with IntelliJ Profiler in the context of optimizing application performance?

- JMeter is used to measure application performance by simulating high workloads (mimicking multiple simultaneous users), essentially testing how the application performs under stress.
- IntelliJ Profiler is used to identify bottlenecks that cause poor or slow application performance, focusing on the internal workings of the code rather than simulating external conditions.

## 2. How does the profiling process help you in identifying and understanding the weak points in your application?

The profiling process is essential for diagnosing performance bottlenecks in my application. During profiling:
- It collects and analyzes runtime data, helping me pinpoint areas that slow down execution.
- It provides crucial insights such as CPU consumption, memory usage, garbage collection behavior, and thread activity.
- By interpreting this data, I can identify specific functions or processes that contribute to performance issues, allowing me to optimize my code effectively.

## 3. Do you think IntelliJ Profiler is effective in assisting you to analyze and identify bottlenecks in your application code?

Yes, because Intellij Profiler provides me with : 
- Flame graphs that visualize which parts of the code consume significant execution time
- Method List tab that provides execution time information
- Diff execution time metrics that show performance improvements after optimization without requiring manual calculations

## 4. What are the main challenges you face when conducting performance testing and profiling, and how do you overcome these challenges?

The main challenges I face are:
- Understanding profiling results: Properly interpreting profiling data to identify actual bottlenecks
- Implementing optimizations: Refactoring code to address identified bottlenecks effectively

## 5. What are the main benefits you gain from using IntelliJ Profiler for profiling your application code?

The main benefits I gain are:
- Integration with the IDE, eliminating the need for third-party applications
- Simplified setup process since profiling is built into the development environment
- Helpful visualizations like flame graphs
- Automatic calculation of performance improvements through diff execution time metrics

## 6. How do you handle situations where the results from profiling with IntelliJ Profiler are not entirely consistent with findings from performance testing using JMeter?

When I encounter inconsistencies between IntelliJ Profiler and JMeter results, I handle them by:
- Recheck JMeter configurations.
- Validate profiling metrics.
- Investigate external factors (e.g., hardware, network latency).

## 7. What strategies do you implement in optimizing application code after analyzing results from performance testing and profiling? How do you ensure the changes you make do not affect the application's functionality?

After analyzing performance testing and profiling results, I optimize my application by:
1. Reducing database calls:
   - Refactored `getAllStudentsWithCourses()` to retrieve all student-course relationships in a single database call
   - Used a HashMap to store student IDs, enabling efficient lookups during StudentCourse iteration

2. Improving data structures for memory allocation:
   - Optimized the `joinStudentNames()` method by replacing String concatenation (+=) with StringBuilder.
   - This reduces unnecessary memory allocation caused by String immutability.

3. Query optimization:
   - Improved the `findStudentWithHighestGpa()` method by replacing manual iteration with a direct SQL query.
   - Used `SELECT * FROM STUDENTS ORDER BY GPA DESC LIMIT 1` to retrieve the student with highest GPA.

To ensure that optimizations don't affect application functionality, I can create unit tests before making any code changes. While I didn't implement tests for this, I know that using unit tests would be the appropriate approach to verify that the application still functions correctly after performance optimizations.