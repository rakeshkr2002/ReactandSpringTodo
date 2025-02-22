import axios from "axios";
import React, { useEffect, useState } from "react";
import '../App.css';
import { TbXboxX } from "react-icons/tb";

const api = "http://localhost:8080/api/todos";

export const Home = () => {
    const [title, setTitle] = useState("");
    const [todos, setTodos] = useState([]);

    useEffect(() => {
        fetchAllTodo();
    }, []);

    const createTodo = async () => {
        const todo = { title };
        try {
            const { data } = await axios.post(api, todo);
            setTodos([...todos, data]);
            setTitle(""); 
        } catch (error) {
            console.log("catch error : ", error);
        }
    };

    const fetchAllTodo = async () => {
        try {
            const { data } = await axios.get(api);
            setTodos(data);
        } catch (error) {
            console.log("catch error : ", error);
        }
    };

    const deleteTodo = async (id) => {
        try {
            await axios.delete(`${api}/${id}`);
            setTodos(todos.filter(todo => todo.id !== id));
            console.log(`Deleted todo with id: ${id}`);
        } catch (error) {
            console.log("catch error : ", error);
        }
    };

    return (
        <div className="container">
            <div className="header">
                <input
                    placeholder="Add New Task"
                    type="text"
                    value={title}
                    onChange={(e) => setTitle(e.target.value)}
                />
                <button onClick={createTodo}>Add</button>
            </div>
            <h1 className="title">List Of Todo</h1>
            <div className="todo-list">
                {todos.map((item, index) => (
                    <div key={item.id} className="todo-item">
                        <p>{index + 1}. {item.title}</p>
                        <button onClick={() => deleteTodo(item.id)} aria-label="Delete">
                        <TbXboxX />
                        </button>
                    </div>
                ))}
            </div>
        </div>
    );
};