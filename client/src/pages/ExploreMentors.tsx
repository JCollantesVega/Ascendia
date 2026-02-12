import MentorGrid from "../features/mentors/components/MentorGrid";
import { useGetMentors } from "../features/mentors/hooks/useGetMentors";

export const ExploreMentors = () => {
    const {mentors, loading, error} = useGetMentors();

    if (loading) return <div className="text-center p-10 font-cinzel text-[#0B5976]">Cargando mentores...</div>;
    if (error) return <div className="text-center p-10 text-red-500 font-bold">{error}</div>;


    return(
        <div>
            <h1>
                Encuentra tu mentor
            </h1>

            {mentors.length == 0 ?(
                <p>No hay mentores disponibles en este momento</p>
            ): (
                <MentorGrid mentors={mentors}/>
            )}
        </div>
    )
}