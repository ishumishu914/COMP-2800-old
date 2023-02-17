public class Hare
{
   int position;

   public void setPosition(int s)
   {
      position = s;
   }
   public int getPosition()
   {
      return position;
   }
   public void Move()
   {
      position += 5;
   }
   public void Sleep()
   {
      position = position;
   }
}
