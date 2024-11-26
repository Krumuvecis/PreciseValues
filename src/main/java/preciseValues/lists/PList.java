package preciseValues.lists;

import preciseValues.pNumber.PNumber;
import preciseValues.errorModel.ErrorType;
import preciseValues.errorModel.NumberError;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * TODO:
 *  * finish this
 *  * finish this javadoc
 *  * add javadoc to members
 */
public class PList extends AbstractPList {
    public <T> PList(@Nullable List<T> members) {
        super(prepareStartingMembers(members));
    }

    private static @NotNull <T> List<PListMember> prepareStartingMembers(@Nullable List<T> members) {
        List<T> nonNullList = Objects.requireNonNullElse(members, new ArrayList<>());
        List<PListMember> startingList = new ArrayList<>();
        if (!nonNullList.isEmpty()) {
            T firstMember = nonNullList.get(0);
            if (firstMember instanceof Double) {
                for (T member : nonNullList) {
                    startingList.add(new PListMember((double) member));
                }
            } else if (firstMember instanceof PNumber) {
                for (T member : nonNullList) {
                    startingList.add(new PListMember((PNumber) member));
                }
            }
        }
        return startingList;
    }

    public PList(NumberError commonError, List<Double> members) {
        super(prepareStartingMembers(commonError, members));
    }

    private static @NotNull List<PListMember> prepareStartingMembers(NumberError commonError,
                                                                     @Nullable List<Double> members) {
        List<PListMember> startingList = new ArrayList<>();
        for (double member : Objects.requireNonNullElse(members, new ArrayList<Double>())) {
            startingList.add(new PListMember(member, commonError));
        }
        return startingList;
    }

    /*
    public PList(@Nullable List<PNumber> members) {
        super(prepareStartingMembers(members));
    }

    private static @NotNull List<PListMember> prepareStartingMembers(@Nullable List<PNumber> members) {
        List<PListMember> startingList = new ArrayList<>();
        for (PNumber member : Objects.requireNonNullElse(members, new ArrayList<PNumber>())) {
            startingList.add(new PListMember(member));
        }
        return startingList;
    }

    public PList(Map<PNumber, Integer> weightedMembers) {
        super(prepareStartingMembers(weightedMembers));
    }

    private static @NotNull List<PListMember> prepareStartingMembers(@Nullable Map<PNumber, Integer> weightedMembers) {
        List<PListMember> startingList = new ArrayList<>();
        Map<PNumber, Integer> nonNullMap = Objects.requireNonNullElse(weightedMembers, new HashMap<>());
        for (PNumber member : nonNullMap.keySet()) {
            int weight = nonNullMap.get(member);
            startingList.add(new PListMember(member, weight));
        }
        return startingList;
    }
    */

    //TODO: add javadoc
    @Override
    public @NotNull NumberError getAbsoluteError() {
        //TODO: finish this
        return null;
    }

    //TODO: add javadoc
    @Override
    public @NotNull NumberError getRelativeError() {
        return getAbsoluteError().getError(ErrorType.RELATIVE, getAverage());
    }
}