import React from 'react';
import TaskListRow from './TaskListRow';
import axios from 'axios';
const log = require('simple-console-logger').getLogger('TaskList');

function buildList(tasks) {
    if (!tasks) return
    return tasks.map(task => {
        return <TaskListRow taskEntry={task} />
    })
}

/**
 * Display the contents of a single task
 */
class TaskList extends React.Component {
    componentDidMount() {
    }

    render() {
        return (
            <div>
                <div>
                    <h2>Tasks</h2>
                </div>
                <table className='table table-hover table-striped'>
                    <thead>
                        <tr>
                            <th scope="col">Name</th>
                            <th scope="col">Topic</th>
                            <th scope="col">Author</th>
                            <th scope="col">Content</th>
                        </tr>
                    </thead>
                    <tbody>
                        {buildList(this.props.tasks)}
                    </tbody>
                </table>
            </div>
        );
    }
}

export default TaskList;