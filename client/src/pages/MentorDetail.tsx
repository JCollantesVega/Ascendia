import { useParams } from 'react-router';
import { useGetMentorDetail } from '../features/mentors/hooks/useGetMentorDetail';

const MentorDetail = () => {
    const { id } = useParams();
    const { mentor, loading } = useGetMentorDetail(id);

    console.log("info de mentor:" + mentor);

    //if(loading) return <div className='text-center p-20 text-[#0B5976]'>Cargando perfil...</div>;


    return (
        <div className='min-h-screen bg-slate-50 p-8 text-[#0B5976]'>
            <div className='max-w-6xl min-h-screen mx-auto grid grid-cols-2 md_grid-cols-3 gap-8'>
                
                {/* Columna izquierda : bio de mentor*/ }
                <div className='w-full bg-green-300'>
                    <div>
                        <img src={mentor.user.avatarUrl} alt={mentor.user.userName}/>
                    </div>
                    <div>
                        <h2>{mentor.user.userName}</h2>
                    </div>
                    <div>
                        <p>{mentor.bio}</p>
                    </div>
                    <div>
                        <h3>Especialidades</h3>
                        {mentor.speciality.map((spec: string) => (
                            <span key={spec}>
                                {spec}
                            </span>
                        ))}
                    </div>
                </div>

                {/* Columna derecha : reservas*/ }
                <div className='w-full bg-red-200'>

                </div>
            </div>
        </div>
    )
}


export default MentorDetail;