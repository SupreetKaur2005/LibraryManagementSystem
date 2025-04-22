-- initial_data.sql for Highracy Library Management System
-- -------------------------------------------------------
-- Inserts basic initial data: Admin, Librarian, Student, Books, and a sample Transaction

-- -------------------------------------------------------
-- Users
-- -------------------------------------------------------
INSERT INTO User (username, password, name, email, role)
VALUES
    ('admin01', 'adminpass', 'Alice Admin', 'admin@highracy.com', 'Admin'),
    ('lib01', 'libpass', 'Bob Librarian', 'librarian@highracy.com', 'Librarian'),
    ('stud01', 'studpass', 'Charlie Student', 'charlie@student.com', 'Student');

-- Link role-specific tables
INSERT INTO Admin (admin_id)
SELECT user_id FROM User WHERE username = 'admin01';

INSERT INTO Librarian (librarian_id)
SELECT user_id FROM User WHERE username = 'lib01';

INSERT INTO Student (student_id, course, year)
SELECT user_id, 'Computer Science', 2 FROM User WHERE username = 'stud01';

-- -------------------------------------------------------
-- Books
-- -------------------------------------------------------
INSERT INTO Book (title, author, publisher, isbn, genre, total_copies, available_copies)
VALUES
    ('Clean Code', 'Robert C. Martin', 'Prentice Hall', '9780132350884', 'Programming', 5, 5),
    ('The Pragmatic Programmer', 'Andrew Hunt & David Thomas', 'Addison-Wesley', '9780201616224', 'Software Engineering', 3, 3),
    ('Introduction to Algorithms', 'Cormen et al.', 'MIT Press', '9780262033848', 'Algorithms', 4, 4);

-- -------------------------------------------------------
-- Transaction
-- -------------------------------------------------------
-- Issue one book to the student
INSERT INTO Transaction (book_id, student_id, issue_date, due_date)
VALUES (
    (SELECT book_id FROM Book WHERE title = 'Clean Code'),
    (SELECT student_id FROM Student WHERE student_id = (SELECT user_id FROM User WHERE username = 'stud01')),
    '2025-04-01',
    '2025-04-15'
);

-- -------------------------------------------------------
-- Notification
-- -------------------------------------------------------
INSERT INTO Notification (user_id, message)
VALUES (
    (SELECT user_id FROM User WHERE username = 'stud01'),
    'Welcome to Highracy! Your library account has been created.'
);

-- -------------------------------------------------------
-- Book Request
-- -------------------------------------------------------
INSERT INTO BookRequest (student_id, book_title, author)
VALUES (
    (SELECT student_id FROM Student WHERE student_id = (SELECT user_id FROM User WHERE username = 'stud01')),
    'Artificial Intelligence: A Modern Approach',
    'Stuart Russell & Peter Norvig'
);

-- -------------------------------------------------------
-- Book Rating
-- -------------------------------------------------------
INSERT INTO BookRating (book_id, student_id, rating, review)
VALUES (
    (SELECT book_id FROM Book WHERE title = 'Clean Code'),
    (SELECT student_id FROM Student WHERE student_id = (SELECT user_id FROM User WHERE username = 'stud01')),
    5,
    'Excellent book for writing maintainable code!'
);

-- End of initial_data.sql
