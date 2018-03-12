import React from 'react';
const log = require('simple-console-logger').getLogger('TaskListRow');

/**
 * Display the contents of a single TaskListRow
 */
class TaskListRow extends React.Component {
    render() {
        var task = this.props.task;
        log.debug(task);
        return (
            <tr>
                <td>{task.name}</td>
                <td>{task.topic}</td>
                <td>{task.author}</td>
                <td>{task.content}</td>
            </tr>
        )
    }
}

export default TaskListRow;