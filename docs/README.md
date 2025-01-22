# Tyrese User Guide
// Product screenshot goes here

## Introduction
What's going on, guys? Tyrese Here!
I'm a pretty chill guy that likes to have keep my stuff in order you know?

Anyways! Here's what I can do for you:
- Add tasks without dates (todo)
- Add deadlines with specific due dates (deadline)
- Schedule events with start and end times (event)
- Track and manage your tasks with ease (list, mark, unmark, delete)

## Features

### Adding Todos
Add a task without a specific date or time.

Usage:
`todo <description>`

Example:
`todo Buy groceries`

Expected Outcome:
A new task "Buy groceries" will be added to your list.

### Adding Deadlines
Add a task with a specific due date.

Usage:
`deadline <description> /by <due date>`

Example:
`deadline Submit assignment /by 2025-01-25`

Expected Outcome:
A new task "Submit assignment" with a due date of 25th January 2025 will be added to your list.

### Adding Events
Add an event with a start and end time.

Usage:
`event <description> /from <start date/time> /to <end date/time>`

Example:
`event Project meeting /from 2025-01-21 10:00 /to 2025-01-21 12:00`
`
Expected Outcome:
A new event "Project meeting" scheduled from 10:00 to 12:00 on 21st January 2025 will be added to your list.

### Deleting Tasks
Delete a task from task list.

Usage:
`delete <task_number>`

Example:
`delete 2`

Expected Outcome:
The task at the specified index will be deleted and the list will be updated accordingly.

### Viewing Your Tasks
Display all your tasks in a list format.

Usage:
`list`

Expected Outcome:
A list of all your tasks, deadlines, and events will be displayed, showing their status (done or not done).

### Marking Tasks as Done
Mark a specific task as completed.

Usage:
`mark <task number>`

Example:
`mark 2`

Expected Outcome:
tasks.Task number 2 will be marked as done.

### Unmarking Tasks
Unmark a specific task as incomplete.

Usage:
`unmark <task number>`

Example:
`unmark 2`

Expected Outcome:
tasks.Task number 2 will be marked as incomplete.

### Exiting the Application:
Say your goodbyes guys!

Usage:
`exit`

Expected Outcome:
The application will close.