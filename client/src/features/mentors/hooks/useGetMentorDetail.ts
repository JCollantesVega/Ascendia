import { useState, useEffect } from "react";
import { API_URL } from "../../../api/config";


export const useGetMentorDetail = (id: string | undefined) => {
    const [mentor, setMentor] = useState<any>(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        if (!id) return;
        fetch(`${API_URL}/mentors/${id}`)
            .then(res => res.json())
            .then(data =>{
                setMentor(data);
                setLoading(false);
            });
    }, [id]);

    return { mentor, loading };
};