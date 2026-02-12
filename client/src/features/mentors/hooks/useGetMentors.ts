import {useState, useEffect} from 'react';
import type { MentorCardProps } from '../../../types/mentor';
import { API_URL } from '../../../api/config';

export const useGetMentors = () => {
    const [mentors, setMentors] = useState<MentorCardProps[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        const fetchMentors = async () => {
            try{
                const response = await fetch(`${API_URL}/mentors`);

                if(!response.ok) throw new Error("Error al conectar con la API");

                const data = await response.json();
                setMentors(data);
            }catch(err){
                setError(err instanceof Error ? err.message : "Error desconocido");
            } finally{
                setLoading(false);
            }
        };

        fetchMentors();
    }), [];


    return {mentors, loading, error};
};