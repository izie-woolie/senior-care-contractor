import { useApplications } from "../hooks/useApplications";

const Home = () => {
  const { data: applications } = useApplications();
  return (
    <section>
      <p>This is Home</p>
      <p>This is {applications?.data}</p>
    </section>
  );
};

export default Home;
