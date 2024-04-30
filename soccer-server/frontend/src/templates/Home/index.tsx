import { Heading } from 'components/Heading';

function Home() {
  return <>
  <Heading>Soccer Search</Heading>
  <table>
    <thead>
      <tr>
        <td>No.</td>
        <td>문제</td>
        <td>답</td>
    </tr>
    </thead>
    <tbody>
      <tr>
        <td>1</td>
        <td>전체 축구팀 목록을 팀이름 오름차순으로 출력</td>
        <td>답</td>
      </tr>
      <tr>
        <td>2</td>
        <td>플레이어의 포지션 종류를 나열 출력</td>
        <td>답</td>
      </tr>
      <tr>
        <td>3</td>
        <td>플레이어의 포지션 종류를 나열</td>
        <td>답</td>
      </tr>
    </tbody>
  </table>
  </>;
}

export default Home;
