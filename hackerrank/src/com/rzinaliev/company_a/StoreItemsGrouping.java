package com.rzinaliev.company_a;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Given list of pairs of groups
 * Each pair means "item1 is frequently bought with item2"
 * thus forming a group of "bought-together" groups
 * The task is to find the biggest group of bought-together groups
 * If there are two or more such groups then pick one which contains
 * item with the smallest value (in lexicographic order)
 *
 * Example:
 * [["Item1", "Item2"],
 *  ["Item1", "Item3"],
 *  ["Item2", "Item4"],
 *  ["Item5", "Item6"],
 *  ["Item6", "Item7"]]
 * Result:
 *  ["Item1", "Item2", "Item3", "Item4"]
 */
public class StoreItemsGrouping {

   public String[] getMaxGroup(String[][] items){

      if(items == null)
         throw new IllegalArgumentException("input items can not be null");

      GroupsCache cache = new GroupsCache();

      for(int i = 0; i < items.length; i++){
         if(items[i].length != 2)
            throw new IllegalArgumentException(String.format("invalid items count %s in line %s", items[i].length, i));

         String itemA = items[i][0];
         String itemB = items[i][1];

         cache.processItems(itemA, itemB);
      }

      return cache.getResultGroupItems();
   }

   static class GroupsCache{

      private HashMap<String, Group> groups = new HashMap<String, Group>();
      private String resultGroupKey;
      private int maxGroupSize;

      public void processItems(String itemA, String itemB){
         Group groupA = groups.get(itemA);
         Group groupB = groups.get(itemB);

         if(groupA == null && groupB == null){
            Group group = createNewGroup(itemA, itemB);
            processGroup(group);
         }else if(groupA != null && groupB == null){
            addNewItem(groupA, itemB);
            processGroup(groupA);
         }else if(groupB != null && groupA == null){
            addNewItem(groupB, itemA);
            processGroup(groupB);
         }else{
            // both are not null
            mergeGroups(groupA, groupB);
            processGroup(groupA);
         }
      }

      private void mergeGroups(Group groupA, Group groupB) {
         for(String item : groupB.getAllItems()){
            groupA.add(item);
            groups.put(item, groupA);
         }
      }

      private void addNewItem(Group group, String item) {
         group.add(item);
         groups.put(item, group);
      }

      private Group createNewGroup(String itemA, String itemB) {
         Group group = new Group(itemA, itemB);

         groups.put(itemA, group);
         groups.put(itemB, group);

         return group;
      }

      private void processGroup(Group group) {
         int groupSize = group.size();

         if(groupSize > maxGroupSize){
            maxGroupSize = groupSize;
            resultGroupKey = group.getMinItem();
         }else if(groupSize == maxGroupSize){
            if(group.getMinItem().compareTo(resultGroupKey) < 0){
               resultGroupKey = group.getMinItem();
            }
         }
      }

      public String[] getResultGroupItems(){
         Group result = groups.get(resultGroupKey);
         if(result != null)
            return result.getAllItems();
         else
            return new String[0];
      }
   }

   static class Group{

      public String getMinItem(){
         return minItem;
      }

      List<String> items = new LinkedList<String>();
      private String minItem;

      public Group(String itemA, String itemB) {
         items.add(itemA);
         items.add(itemB);

         if(itemA.compareTo(itemB) < 0)
            minItem = itemA;
         else
            minItem = itemB;
      }

      public int size() {
         return items.size();
      }

      public void add(String item) {
         items.add(item);

         if(item.compareTo(minItem) < 0){
            minItem = item;
         }
      }

      public String[] getAllItems() {
         return items.toArray(new String[items.size()]);
      }
   }
}
