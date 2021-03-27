package tools.keySet;

/**
 * The KeySet RECORD(!) is another tool used for fast key definition. Make sure
 * that the jdk version is at least 1.12 otherwise this record wont work.
 * 
 * The KeySet class is easy to write in lower version of java. Simply make a
 * static class with static keyValues.
 * 
 * constructor args: moveDown, moveUp, moveLeft, moveRight
 */

@SuppressWarnings("preview")
public record KeySet(int moveDown, int moveUp, int moveLeft, int moveRight)
{
}